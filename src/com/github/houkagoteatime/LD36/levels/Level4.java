package com.github.houkagoteatime.LD36.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.github.houkagoteatime.LD36.entities.Entity;
import com.github.houkagoteatime.LD36.entities.enemies.EnemySpawner;
import com.github.houkagoteatime.LD36.entities.enemies.MeleeEnemy;
import com.github.houkagoteatime.LD36.screens.GameScreen;
import com.github.houkagoteatime.LD36.weapons.BowAndArrow;

public class Level4 extends Level{

	boolean attacked = false;
	Sprite projectileSprite = new Sprite(new Texture(Gdx.files.internal("assets/pictures/arrow.png")));
	private int tick = 0;
	
	public Level4(GameScreen screen) {
		super("assets/tilesets/level4a.tmx", screen);
		//this.setLevel(4);
		EnemySpawner.init(this);
		this.getPlayer().setxPosition(70);
		this.getPlayer().setyPosition(63);
		this.getPlayer().setHealth(10);
	}
	
	public void update(float dt) {
		tick++;
		//dont judge
		if(tick % 2 == 0) {
		if(!attacked) {
			this.getPlayer().iFrameCounter = 9001;
			new BowAndArrow(this.getEnemies().get(2), this).fireProjectile(190);
			/*this.getProjectiles().add(new Arrow(new Sprite(new Texture(Gdx.files.internal("assets/pictures/arrow.png"))), 0, 
					100, 100, 
					190, 500, false));*/
			attacked = true;
		}
		//this.getPlayerInputProcessor().queryInput();
		this.getPlayer().update(dt);
		updateProjectiles(dt);
		handleProjectileCollision(dt);
		handleGameObjects();
		//dont judge
		//x)
		if(tick > 140) {
			getPlayer().setHealth(0);
		}
		if(this.getPlayer().isDead()) {
			getGame().gameOver();
		}
		} else {
			return;
		}
	}
	@Override
	public void nextLevel() {
		// TODO Auto-generated method stub
		
	}

}
