package com.qiaomu.compiler;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by qiaomu on 2017/10/9.
 */
public class ProxyInfo {
    private String packageName;
    private String proxyClassName;
    private TypeElement typeElement;
    ExecutableElement method;
    private static final String PROXY = "NetStateProxy";

    ProxyInfo(Elements elementUtils, TypeElement classElement) {
        PackageElement packageElement = elementUtils.getPackageOf(classElement);
        String packageName = packageElement.getQualifiedName().toString();
        //classname
        String className = ClassValidator.getClassName(classElement, packageName);
        this.packageName = packageName;
        this.proxyClassName = className + "$$" + PROXY;
    }


    String getProxyClassFullName() {
        return packageName;
    }

    TypeSpec generateJavaCode() {
        ClassName originClass = ClassName.get(packageName, typeElement.getSimpleName().toString());
        // 方法
        MethodSpec getIdMeth = MethodSpec.methodBuilder("onNetChange")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ParameterSpec.builder(Object.class, "source").build())
                .addParameter(ParameterSpec.builder(boolean.class, "isAvailable").build())
                .addCode(" if(source instanceof " + originClass +")"+
                        "{ (("+originClass+")source)." + method.getSimpleName().toString() + "(isAvailable);}")
                .returns(void.class)
                .build();

        ClassName proxyInterface = ClassName.get("com.qiaomu.libpermission", "NetStateProxy");
//        TypeName listOfStudent = ParameterizedTypeName.get(proxyInterface, originClass);
        return TypeSpec.classBuilder(proxyClassName)
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(proxyInterface)
                .addMethod(getIdMeth)
                .build();
    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    void setTypeElement(TypeElement typeElement) {
        this.typeElement = typeElement;
    }


}