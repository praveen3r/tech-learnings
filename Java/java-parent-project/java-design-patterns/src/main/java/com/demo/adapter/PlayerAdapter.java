package com.demo.adapter;

public class PlayerAdapter implements AdvancedMediaPlayer{
	
	MediaPlayer mediaPlayer;
	
	public PlayerAdapter(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	public void playMp4() {
		System.out.println(" Inside Adapter");
		mediaPlayer.play();
	}

	

}
