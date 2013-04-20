package com.andthen.actor;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class AnimalActor extends Actor implements Disposable{

	//��Ա��Ҫ�·�
	ArrayList<Texture> texArray = new ArrayList<Texture>();
	//����
	ArrayList<TextureRegion> texReArray = new ArrayList<TextureRegion>();
	//��Ա��Ҫ�ݼ�
	Animation animation;
	//�ݼ��ж���
	TextureRegion[] walksFrame;
	float stateTime;
	TextureRegion currentFrame;//��ǰ֡
	
	//��ͬ�����첽֮��,��������Զ��Ե�,ͬ������render()����,�첽������һ���߳�,
	//���������UI�̶߳����첽��
	AssetManager manager;//����progress���汣���managerʵ��
	
	public AnimalActor(AssetManager manager){
		super();
	    //����Progress�ڵ�AssetManager
		this.manager = manager;
	}


	@Override
	public void draw(SpriteBatch batch, float arg1) {
		// TODO Auto-generated method stub
		stateTime +=Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		//��(0,0)����Ϊ��㣨���½�Ϊ0��0��������������С128*128
		batch.draw(currentFrame, 0, 0, 128, 128);
				
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean touchDown(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touchDragged(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touchUp(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	//��ʼ����������Progress�е�AssetManager��ʼ����ɺ�֪ͨAnimalActor��ʼ��
	public void iniResource(){
		Texture tex;
		int j;
		for(int i=1;i<30;i++){
			texArray.add(manager.get("animal/"+i+".png", Texture.class));
		}
		
		for(int i=0;i<texArray.size();i++){
			tex = texArray.get(i);
			TextureRegion temtex = new TextureRegion(tex);
			texReArray.add(temtex);//�����ϼ��·�
		}
		
		j = texReArray.size();
		walksFrame = new TextureRegion[j];
		for(int i=0;i<j;i++){
			//���õ���0.06sһ֡
			animation = new Animation(0.06f, walksFrame);
		}
	}
	
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		for(int i=0;i<texArray.size();i++)
			texArray.get(i).dispose();
	}

}
