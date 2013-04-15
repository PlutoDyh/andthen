package com.andthen.ui;

import android.app.Activity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class ExitDialog {
	
	Stage stage;
	Button yes, no;
	Texture tex;
	Window dialog;
	BitmapFont bf;
	Activity activity;
	
	public boolean hasDialog = false;
	public ExitDialog(Stage stage, Activity activity){
		this.stage = stage;
		this.activity = activity;
		hasDialog = true;
		tex = new Texture(Gdx.files.internal("button1_480.png"));
		bf = new BitmapFont(Gdx.files.internal("font.fnt"), false);
	}
	
	public Window makeup(){
		
		Gdx.app.log("exit dialog", "makeup");
		NinePatch n1 = new NinePatch(tex, 7, 7, 9, 9); 

		dialog=new Window("dialog",new Window.WindowStyle(bf, Color.WHITE, n1));
		//��һ���򵥵�����,����1.2��Ϊ����ͼƬ��ʾ������ʱ���һ��
        dialog.width=512*1.2f*Gdx.graphics.getWidth()/800f;
        dialog.height=256*1.2f*Gdx.graphics.getWidth()/800f;
        //Ϊ����ͼƬ���־���
        dialog.x=(Gdx.graphics.getWidth()-dialog.width)/2;
        dialog.y=(Gdx.graphics.getHeight()-dialog.height)/2;
        
        yes=new Button(new TextureRegion(new Texture(Gdx.files.internal("button1_480.png")), 160, 80));
        yes.x=30;
        yes.y=60;
        //��ok�����ť��Ӽ�����
        yes.setClickListener(new ClickListener() {
                
                @Override
                public void click(Actor arg0, float arg1, float arg2) {
                        // TODO Auto-generated method stub
                        //�رճ���
                         activity.finish();
                         android.os.Process.killProcess(android.os.Process.myPid());
                }
        });
        no=new Button(new TextureRegion(new Texture(Gdx.files.internal("button1_480.png")), 160, 80));
        no.x=200;
        no.y=60;
        no.setClickListener(new ClickListener() {
                
                @Override
                public void click(Actor arg0, float arg1, float arg2) {
                        // TODO Auto-generated method stub
                        //�Ƴ��Ի���
                        stage.removeActor(dialog);
                        hasDialog = false;
                }
        });
        dialog.addActor(yes);
        dialog.addActor(no);
        
        return dialog;
	}
}
