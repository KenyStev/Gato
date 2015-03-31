package Zero.Studio.Gato;

import java.util.Scanner;

public class Gato {
	
	static char cat[][] = new char[3][3]; // Arreglo del gato
	static Scanner scan = new Scanner(System.in); // recibir entradas
	static int turno = 0; // verificar el turno
	static int F, C; // Recibir posicion en fila y columna
	static int tres=3; // constante de 3
	static int whoPlayou = 0;

	public static void main(String[] args) {
		init();
		playVsWho();
		printCat();
		while(true){
			setPosition();
			printCat();
			winer();
		}
	}
	
	// Metodo para que el CPU haga su turno
	static void turnCPU(){
//		int cont = 1, iter = 0;
//		while(cont==1){
//			
//			
//			for(int i =0; i<tres;i++){
//				if(cat[iter][i]==' '){
//					cat[iter][i]='O';
//				}
//			}
//			if(iter==2)
//				iter=0;
//			else
//				iter++;
//			
//		}
		
		//Verificar donde va ganado el Usuario
		switch(winer2()){ // winer2 devuelve un String
		case "f0":
			
			break;
		}
		
		
	}
	
	//Verificar el tipo de juego
	static void playVsWho(){
		System.out.println("Como desea Jugar?");
		System.out.println("0. Jugar vs Person");
		System.out.println("1. Jugar vs CPU");
		System.out.print("Escoja su Opcion: ");
		whoPlayou = scan.nextInt();
	}
	
	static void winer(){
		int fx =0, f0 =0, cx =0, c0 =0, xpx =0, xp0 =0, xnx =0, xn0 =0; 
		
		for(int i=0; i<cat.length;i++){
			fx =0; f0 =0; cx =0; c0 =0;
			for(int j=0;j<cat.length;j++){
				if(cat[i][j]=='X'){
					fx++;
					if(fx==tres){
						System.out.printf("Win the X in Row %d", i);
						System.exit(0);
					}
				}
				if(cat[i][j]=='O'){
					f0++;
					if(f0==tres){
						System.out.printf("Win the O in Row %d", i);
						System.exit(0);
					}
				}
				if(cat[j][i]=='X'){
					cx++;
					if(cx==tres){
						System.out.printf("Win the X in Column %d", i);
						System.exit(0);
					}
				}
				if(cat[j][i]=='O'){
					c0++;
					if(c0==tres){
						System.out.printf("Win the O in Row %d", i);
						System.exit(0);
					}
				}
				if(i==j){
					if(cat[i][j]=='X'){
						xnx++;
						if(xnx==tres){
							System.out.printf("Win the X in xnx");
							System.exit(0);
						}
					}
					if(cat[i][j]=='O'){
						xn0++;
						if(xn0==tres){
							System.out.printf("Win the O in xnx");
							System.exit(0);
						}
					}
				}
				if(i+j==tres-1){
					if(cat[i][j]=='X'){
						xpx++;
						if(xpx==tres){
							System.out.println("Win the X in xpx");
							System.exit(0);
						}
					}
					if(cat[i][j]=='O'){
						xp0++;
						if(xp0==tres){
							System.out.println("Win the 0 in xpx");
							System.exit(0);
						}
					}
				}
			}
		}
	}
	
	static String winer2(){
		int fx =0, f0 =0, cx =0, c0 =0, xpx =0, xp0 =0, xnx =0, xn0 =0; 
		boolean send = false;
		
		for(int i=0; i<cat.length;i++){
			fx =0; f0 =0; cx =0; c0 =0;
			for(int j=0;j<cat.length;j++){
				if(cat[i][j]=='X'){
					fx++;
					if(fx==tres-1){
						System.out.printf("Win the X in Row %d", i);
						return "f"+i;
					}
				}
				if(cat[i][j]=='O'){
					f0++;
					if(f0==tres){
						System.out.printf("Win the O in Row %d", i);
					}
				}
				if(cat[j][i]=='X'){
					cx++;
					if(cx==tres-1){
						System.out.printf("Win the X in Column %d", i);
						return "c"+i;
					}
				}
				if(cat[j][i]=='O'){
					c0++;
					if(c0==tres){
						System.out.printf("Win the O in Row %d", i);
					}
				}
				if(i==j){
					if(cat[i][j]=='X'){
						xnx++;
						if(xnx==tres-1){
							System.out.printf("Win the X in xnx");
							return "n";
						}
					}
					if(cat[i][j]=='O'){
						xn0++;
						if(xn0==tres){
							System.out.printf("Win the O in xnx");
						}
					}
				}
				if(i+j==tres-1){
					if(cat[i][j]=='X'){
						xpx++;
						if(xpx==tres-1){
							System.out.println("Win the X in xpx");
							return "p";
						}
					}
					if(cat[i][j]=='O'){
						xp0++;
						if(xp0==tres){
							System.out.println("Win the 0 in xpx");
						}
					}
				}
			}
		}
		return " ";
	}
	
	static void setPosition(){
		if(turno==0)
			System.out.println("Truno de X");
		else if(turno==1)
			System.out.println("Truno de 0");
		
		if(whoPlayou==0){
			System.out.print("Ingese la Posocion: ");
			F = scan.nextInt();
			C = scan.nextInt();
			switch(turno){
			case 0:
				setX(F,C);
				break;
			case 1:
				set0(F,C);
				break;
			}
		}else if(whoPlayou==1){
			switch(turno){
			case 0:
				System.out.print("Ingese la Posocion: ");
				F = scan.nextInt();
				C = scan.nextInt();
				setX(F,C);
				break;
			case 1:
				System.out.println("Truno de CPU");
				turnCPU(); //turn CPU
				break;
			}
		}
		System.out.println();
	}
	
	static void setX(int f, int c){
		if((f < cat.length) && (c)< cat.length){
			if (cat[f][c] == ' ') {
				cat[f][c] = 'X';
				turno = 1;
			} else {
				System.out.println("Puesto Ocupado!");
			}
		}else{
			System.out.println("Posicion no Valida!");
		}
	}
	
	static void set0(int f, int c){
		if((f < cat.length) && (c)< cat.length){
			if (cat[f][c] == ' ') {
				cat[f][c] = 'O';
				turno = 0;
			} else {
				System.out.println("Puesto Ocupado!");
			}
		}else{
			System.out.println("Posicion no Valida!");
		}
	}
	
	static void printCat(){
		for(int i=0; i<cat.length;i++){
			for(int j=0; j<cat[i].length;j++){
				System.out.printf("| %c |", cat[i][j]);
			}
			System.out.println();
		}
	}
	
	static void init(){
		for(int i=0; i<cat.length;i++){
			for(int j=0; j<cat[i].length;j++){
				cat[i][j] = ' ';
			}
		}
	}

}
