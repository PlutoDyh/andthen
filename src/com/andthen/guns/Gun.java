package com.andthen.guns;

public class Gun {
	
	int damage;          //�˺�
	int firerate;        //����
	int accuracy;        // ��׼��
	int reloadtime;       //װ��ʱ��
	int magazines;        //��������
	int maxsize;          //���Я����
	int maxleft;          //���Я����
	int is_lock;
	int gun_cost;
	int bullet_cost;
	String name;
	String texture;
	
	public Gun(){
		texture="pistol.png";
		damage=16;
		maxsize=400;
		magazines=15;
		maxleft=300;
		reloadtime=500000000;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMagazines() {
		return magazines;
	}

	public void setMagazines(int magazines) {
		this.magazines = magazines;
	}

	public int getMaxsize() {
		return maxsize;
	}

	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}
	
	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public int getMaxleft() {
		return maxleft;
	}

	public void setMaxleft(int maxleft) {
		this.maxleft = maxleft;
	}

	public int getFirerate() {
		return firerate;
	}

	public void setFirerate(int firerate) {
		this.firerate = firerate;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getReloadtime() {
		return reloadtime;
	}

	public void setReloadtime(int reloadtime) {
		this.reloadtime = reloadtime;
	}

	public int getIs_lock() {
		return is_lock;
	}

	public void setIs_lock(int is_lock) {
		this.is_lock = is_lock;
	}

	public int getGun_cost() {
		return gun_cost;
	}

	public void setGun_cost(int gun_cost) {
		this.gun_cost = gun_cost;
	}

	public int getBullet_cost() {
		return bullet_cost;
	}

	public void setBullet_cost(int bullet_cost) {
		this.bullet_cost = bullet_cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	
}
