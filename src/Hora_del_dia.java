public class Hora_del_dia {
    private int hora,minuto,segundo; //Instancias

    //---------------------------------Constructores----------------------------
    public Hora_del_dia(){
        hora=12;
        minuto=0;
        segundo=0;
    }
    public Hora_del_dia(int seg){
        hora=seg/3600;
        minuto=(seg%3600)/60;
        segundo = (seg%3600)% 60;
    }
    public Hora_del_dia(int hr,int min,int seg){
        hora=hr;
        minuto=min;
        segundo=seg;
    }

    public void saludo (){
        System.out.println("Holii Lucaas");}

    //---------------metodos---------------
    public void setReloj(int seg){
        hora=seg/3600;
        minuto=(seg%3600)/60;
        segundo = (seg%3600)% 60;
    }
    public int getHora(){
        return hora;
    }
    public int getMinuto(){
        return minuto;
    }
    public int getSegundo(){
        return segundo;
    }
    public void setHora(int hr){
        hora=hr;
    }
    public void setMinuto(int min){
        minuto=min;
    }
    public void setSegundo(int seg){
        segundo=seg;
    }
    public void tick(){
        segundo+=1;
        if(segundo==60){
            segundo=0;
        }
    }
    public void addReloj(Hora_del_dia re){
        hora=re.getHora();
        minuto=re.getMinuto();
        segundo=re.getSegundo();
    }
    public static String toString(Hora_del_dia re){   //Lo cree estatico pq me parece absurdo tener que crear 2 objetos para mostrar 1 >
        return "["+re.getHora()+":"+re.getMinuto()+":"+re.getSegundo()+"]";
    }
    public void tickDecrement(){
        segundo-=1;
        if(segundo<0){
            segundo=59;
        }
    }
    public String restaReloj(Hora_del_dia re){
        int diferencia_hora=Math.abs(re.getHora()-hora);
        int diferencia_min=0;
        int diferencia_seg=0;
        //------------------------------------------segundos
        if(segundo==0 && re.getSegundo()==0){
            diferencia_seg=0;
        }
        else if(segundo==0){
            segundo=60;
            minuto-=1;
            diferencia_seg=Math.abs(segundo-re.getSegundo());
        }
        else diferencia_seg=Math.abs(segundo-re.getSegundo());
        //--------------------------------minuto
        if(minuto==0 && re.getMinuto()==0){
            diferencia_min=0;
        }
        else if(minuto==0){
            minuto=60;
            hora-=1;
            diferencia_min=Math.abs(minuto-re.getMinuto());
        }else diferencia_min=Math.abs(minuto-re.getMinuto());


        hora=diferencia_hora; minuto=diferencia_min; segundo=diferencia_seg;

        return "["+diferencia_hora +":"+diferencia_min+":"+diferencia_seg+"]";

    }
    public static void main(String[] args){
        Hora_del_dia reloj1=new Hora_del_dia(16700);
        Hora_del_dia reloj2=new Hora_del_dia();
        //resta de relojes funciona
        System.out.println("el resultado de la resta de los relojes es= "+reloj1.restaReloj(reloj2));
        System.out.println(toString(reloj1));
        //agrega un segundo funciona
        reloj1.tick();reloj1.tick();reloj1.tick();reloj1.tick();reloj1.tick();
        reloj1.tick();reloj1.tick();reloj1.tick();reloj1.tick();reloj1.tick();
        System.out.println(toString(reloj1));

    }
}
