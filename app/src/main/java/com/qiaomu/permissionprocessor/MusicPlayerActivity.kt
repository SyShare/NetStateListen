package com.qiaomu.permissionprocessor

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


/**
 * Administrator create by 2020/1/7
 * not easy to coding
 * please don't modify at will!
 */
class MusicPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        player.setOnClickListener {
//            if (mPlayer?.isPlaying == false)
            Thread(Runnable { initMusicPlayer()  },"test").start()

//            else
//                mPlayer?.start()
        }

        stop.setOnClickListener {
//            mPlayer?.stop()
//            mPlayer?.reset()
        }
//        mPlayer =  MediaPlayer()//.create(this,R.raw.collision)
    }


    @Throws(IOException::class)
    private fun initMusicPlayer() {
        var   mPlayer:MediaPlayer? =  MediaPlayer()
        val afd = assets.openFd("collision.ogg")
        mPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
        mPlayer?.setOnPreparedListener(OnPreparedListener { mediaPlayer ->
            mediaPlayer.start()

        })
        mPlayer?.prepare()
//        mPlayer?.start()
        //mPlayer.getCurrentPosition();
    }
}