package jeu;

import java.util.Random;

public class De {
private De() {
		
	}
	
	protected static int lanceDe(Random random) {
		int de=random.nextInt(6)+1;
		de+=random.nextInt(6)+1;
		return de;
	}
}
