package com.andthen.screen;

import com.andthen.actor.AnimalActor;
import com.andthen.actor.ProgressBar;
import com.andthen.main.AndThenGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Loading extends AbstractScreen{
	
	ProgressBar bar;
	AnimalActor animal;
	Stage stage;
	AssetManager manager;
	boolean hasini;

	public Loading(AndThenGame game) {
		// TODO Auto-generated method stub
		
		super(game);
		
		bar = new ProgressBar(0, 0);
		//��������̨
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		stage.addActor(bar);
		//�ǵó�ʼ��һ��AssetManagerʵ��
		manager = new AssetManager();
		//����AssetManger�����ã�����animal����Դ��ʼ��������ע���ˣ�ֻ���ڵ���iniResourse()����Դ�ű���ʼ��
		animal = new AnimalActor(manager);
		//����Դ���������б�,�����ҷ���һ��29֡�Ķ�������asset�ļ�����animal����29��ͼƬ
		//��û��������
		for(int i=1;i<30;i++)
			manager.load("animal/"+i+".png", Texture.class);

	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		bar.dispose();
		animal.dispose();
		manager.clear();
		manager.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1f, 1f, 1f, 0f);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		//update����������,������ͷ���true
		if(!manager.update()){
			bar.setProgress(manager.getProgress()*100);
		}
		//���������֮ǰû�г�ʼ����AnimalActor�������ִ�����Ļʱ��ʼ��AnimalActor,
		//��������������̨���Ƴ���������AnimalActor����
		if(!hasini && manager.update() && Gdx.input.isTouched()){
		   stage.removeActor(bar);
           animal.iniResource();
//	           stage.addActor(animal);
           hasini=true;
           this.game.setScreen(game.getMenuScreen());
		}
		
	   //������һ����ǣ�����δ���أ�Queued����ɵ���Դ����������ɵ���Դ��������Loaded��
       if(!manager.update()){
	       System.out.println("QueuedAssets:"+manager.getQueuedAssets());
	       System.out.println("LoadedAssets:"+manager.getLoadedAssets());
	       System.out.println("Progress:"+manager.getProgress());
       }
	}

}
