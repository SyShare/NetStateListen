package com.qiaomu.compiler;

import com.google.auto.service.AutoService;
import com.qiaomu.annotation.NetChangeState;
import com.squareup.javapoet.JavaFile;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import static javax.lang.model.SourceVersion.latestSupported;

/**
 * Created by qiaomu on 2017/10/9.
 */
@AutoService(Processor.class)
public class PermissionProcessor extends AbstractProcessor {
    private Elements mElementUtils;
    private Messager mMessager;
    private Map<String, ProxyInfo> mProxyMap = new HashMap<String, ProxyInfo>();


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mElementUtils = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> supportTypes = new LinkedHashSet<>();
        supportTypes.add(NetChangeState.class.getCanonicalName());
        return supportTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        mProxyMap.clear();
        mMessager.printMessage(Diagnostic.Kind.NOTE, "process...");

        if (!processAnnotations(roundEnv, NetChangeState.class)) return false;

        for (String name : mProxyMap.keySet()) {
            ProxyInfo proxyInfo = mProxyMap.get(name);
            try {
                JavaFile javaFile = JavaFile.builder(proxyInfo.getProxyClassFullName(), proxyInfo.generateJavaCode())
                        .build();
                javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private boolean processAnnotations(RoundEnvironment roundEnv, Class<? extends Annotation> annotationClaz) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotationClaz);
        for (Element element : elements) {
            if (!checkMethodValidate(element, annotationClaz)) return false;
            ExecutableElement method = (ExecutableElement) element;
            TypeElement enclosingElement = (TypeElement) method.getEnclosingElement();
            String qualifiedName = enclosingElement.getQualifiedName().toString();

            ProxyInfo proxyInfo = mProxyMap.get(qualifiedName);
            if (proxyInfo == null) {
                proxyInfo = new ProxyInfo(mElementUtils, enclosingElement);
                mProxyMap.put(qualifiedName, proxyInfo);
                proxyInfo.setTypeElement(enclosingElement);
            }

            Annotation annotation = method.getAnnotation(annotationClaz);
            if (annotation instanceof NetChangeState) {
                TypeMirror typeMirror = method.getReturnType();
                if (typeMirror.getKind() != TypeKind.VOID)
                    throw new RuntimeException(method.getSimpleName() + "Method return must be void");
                List<?> parameters = method.getTypeParameters();
                if (parameters.size() != 2) {
                    throw new RuntimeException(method.getSimpleName() + "Method can only have two parameter");
                }
                proxyInfo.method = method;
            } else {
                error(element, "%s not support .", annotationClaz.getSimpleName());
                return false;
            }
        }
        return true;
    }

    private boolean checkMethodValidate(Element element, Class claz) {
        if (element.getKind() != ElementKind.METHOD) {
            error(element, "%s must be declared on method.", claz.getSimpleName());
            return false;
        }
        if (ClassValidator.isPrivate(element) || ClassValidator.isAbstract(element)) {
            error(element, "%s() must can not be abstract or private.", element.getSimpleName());
            return false;
        }

        return true;
    }

    private void error(Element element, String message, Object... objs) {
        if (objs.length > 0) {
            message = String.format(message, objs);
        }
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message, element);
    }
}
