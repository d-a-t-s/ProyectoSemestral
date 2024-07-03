package Logica;
//De arriba hacia abajo "incrementa la distancia", por lo tanto es mas caro
public enum TipoDestino{
    PAPUSVILLE(3){
    },
    TILINTOWN(5){
    },
    SIGMACITY(7){
    },
    SKIBIDISPRINGS(8){
    },
    MAWINGMETROPOLIS(10){
    };
    //Propiedades
    private int tiempo;
    //Constructor
    TipoDestino(int precio){
        this.tiempo = precio;
    }
    public int getTiempo(){
        return tiempo;
    }
}
