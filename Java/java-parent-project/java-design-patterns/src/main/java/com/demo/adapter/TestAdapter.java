package com.demo.adapter;

public class TestAdapter {

	/*
	 * Adapts two different incompatable interfaces
	 */
	public static void main(String[] args) {

		MediaPlayer mediaplayer = new VlcMediaPlayer();
		mediaplayer.play();
		
		AdvancedMediaPlayer advancedMediaPlayer = new Mp4Player();
		advancedMediaPlayer.playMp4();
		
		PlayerAdapter playerAdapter = new PlayerAdapter(mediaplayer);
		playerAdapter.playMp4();
		
		PlayerAdapter2 playerAdapter2 = new PlayerAdapter2();
		playerAdapter2.playMp4();
	}

}
