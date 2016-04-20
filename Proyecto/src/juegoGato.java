import java.io.*;
public class juegoGato {
	
	  
	    public char [] [] tablero;
	    public char rufian;
	    public char rufian2;
	    public boolean turno;
	    int contador;        
	    public juegoGato(){
	        
	        tablero      = new char[3][3];                
	        rufian   = 'X';
	        rufian2   = 'O';
	        turno        = true;   
	        int contador = 0;      
	        inicializarTablero();  
	    }
	        
	    public void inicializarTablero(){
	        
	        int posicion = 1;
	        
	        for(int i=0;i<3;i++){
	                
	                for(int j=0; j<3;j++){
	                        
	                        tablero[i][j] = Integer.toString(posicion).charAt(0);
	                        posicion++;
	                }                       
	        }
	    }
	    
	    public void imprimirTablero(){
	                
	        for(int i=0;i<3;i++){
	                
	                for(int j=0;j<3;j++){
	                        
	                        if(j<2)
	                        
	                                System.out.print(" " + tablero[i][j] + " |");
	                        
	                        else
	                                
	                                System.out.print(" " + tablero[i][j] + " ");
	                                                                
	                }
	                
	                if(i<2)
	                        
	                        System.out.println("\n-----------");                                                                    
	        }
	        System.out.println();
	        System.out.println();
	        System.out.println();
	    }
	       
	    public void indicarPosicionArreglo (int a, int b, char c) {tablero [a][b]=c;}
	     
	    public void setTurno            
	    (boolean d)            {turno         =d;}
	     
	    public void setContador            (int e)                {contador      =e;} 
	    
	     
	    public char getPosicionArreglo (int a, int b)  {return tablero[a][b];} 
	        
	  
	    public char getJugadorUno      ()  {return rufian   ;}            
	   

	    public char getJugadorDos      ()  {return rufian2   ;}            
	  
 
	    public boolean getTurno        ()  {return turno        ;}
              
	    public int getContador         ()  {return contador     ;}           
	    
	    
	    public void indicarTurno(){
	        
	        if(getTurno()==true)
	                
	                System.out.println("JUGADOR 1: Elija Una Casilla Ingresando El Numero Correspondiente.");
	                
	        else
	                
	                System.out.println("JUGADOR 2: Elija Una Casilla Ingresando El Numero Correspondiente.");       
	    }
	    
	    public char obtenerFigura(){
	        
	        if(getTurno()==true)
	                
	                return rufian;
	                
	        else
	                
	                return rufian2;      
	    }
	    
	    public void cambiarTurno(){         
	        
	        if(obtenerFigura()=='X')
	                
	                setTurno(false);    
	        else

	                setTurno(true); 
	    }
	      
  
	    public void comprobarEspacio(char espacio, int posicionUno, int posicionDos){
	      
	        
	        if(espacio!=getJugadorUno()&&espacio!=getJugadorDos()){ 
	                
	           indicarPosicionArreglo(posicionUno, posicionDos,obtenerFigura());
	           cambiarTurno();                                                    
	           contador++;                                                                    
	        }
	        
	        else
	         
	                                       
	           System.out.println("Trata de colocar tu ficha en otra posicion, esta ya esta ocupada");                 
	    }
	              
	    public void elegirPosicion(int posicion){
	                           
	            switch(posicion){
	                
	             
	                        case 1:comprobarEspacio(getPosicionArreglo(0,0),0,0);break;
	                        case 2:comprobarEspacio(getPosicionArreglo(0,1),0,1);break;
	                        case 3:comprobarEspacio(getPosicionArreglo(0,2),0,2);break;
	                        case 4:comprobarEspacio(getPosicionArreglo(1,0),1,0);break;
	                        case 5:comprobarEspacio(getPosicionArreglo(1,1),1,1);break;
	                        case 6:comprobarEspacio(getPosicionArreglo(1,2),1,2);break;
	                        case 7:comprobarEspacio(getPosicionArreglo(2,0),2,0);break;
	                        case 8:comprobarEspacio(getPosicionArreglo(2,1),2,1);break;
	                        case 9:comprobarEspacio(getPosicionArreglo(2,2),2,2);break;
	                        default:
	                   
	                                System.out.println("Por Favor, solo ingrese numeros del 1 al 9");break;                              
	            }           
	    }
	     
	    public void decirGanador(char a){
	        
	        
	        if(a=='X')
	                                
	                System.out.println("Se acabo, el jugador 1 ha ganado la partida!!");
	        
	                
	        else if(a=='O')
	                            
	                    System.out.println("Se acabo, jugador 2 es el ganador!!!!");                      
	                
	                                
	    }
	    
	    public void buscarGanador(){
	                  
	        for(int i=0;i<3;i++){
	                
	                for(int j=1;j<2;j++){
	                        
	                        if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
	                                                        
	                           decirGanador(tablero[i][j]);
	                           imprimirTablero();
	                           setContador(10);
	                        }                               
	                }                       
	        }
	   
	        for(int i=0;i<3;i++){
	                
	                for(int j=1;j<2;j++){
	                        
	                        if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
	                        
	                           decirGanador(tablero[j][i]);
	                           imprimirTablero();
	                           setContador(10);
	                        }                               
	                }
	        }
	           
	        if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
	        
	           decirGanador(tablero[1][1]);
	           imprimirTablero();
	           setContador(10);
	        }   
	           
	        if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
	                
	           decirGanador(tablero[1][1]);
	           imprimirTablero();                   
	           setContador(10);
	        }       
	    }    
	        

	    public void jugarGato(){
	        
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	        
	        System.out.println("Bienvenido a: Tic Tac Dedo, o como era?");       
	                
	        do{
	        
	                indicarTurno();                 
	                imprimirTablero();      
	                try{elegirPosicion(Integer.parseInt(entrada.readLine()));}
	                catch(IOException e){}    
	                catch(NumberFormatException e){
	                        
	                        if(getTurno()==true)
	                           
	                           System.out.println("estimado jugador 1, no sea un rufian, aqui solo se ponen numeros");
	                        
	                        else
	                                
	                           System.out.println("Creo que te has equivocado, aqui solo van numeros");       
	                }
	                         
	                buscarGanador();
	        
	        }while(getContador()<9);
	        
	          if(getContador()==9){
	                
	                System.out.println("baia baia, parece que tenemos un problemirijillo por aqui :v");                                        
	            imprimirTablero();
	                       
	          }
	         
	         System.out.println("Muchas gracias por jugar, tio eres un gran chaval");             
	    }
	    
	    public static void main(String [] args){
	        
	        juegoGato Objeto = new juegoGato();
	        
	        Objeto.jugarGato();     
	                                                                                        
	    }    
	}