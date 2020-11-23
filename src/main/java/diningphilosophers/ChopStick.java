package diningphilosophers;

public class ChopStick {
    // Le nombre total de baguettes
    private static int stickCount = 0;
    // Le numéro de chaque baguette
    private final int myNumber;
    // Est-ce que ma baguette est libre ?
    private boolean iAmFree = true;
    public Philosopher philosophe;

    public ChopStick() {
        // Chaque baguette est numérotée 
        myNumber = ++stickCount;
    }

    // Retourne faux si la baguette n'était pas libre
    // Retourne vrai si la baguette était libre, la fait passer en état "non libre"
    public boolean take(Philosopher philosophe){
        if(iAmFree){
            iAmFree = false;
            this.philosophe = philosophe;
            System.out.println("*"+this.toString()+" prise par "+philosophe.getName()+"*");
            return true;
        }else{
            System.out.println(philosophe.getName()+" a essayé de prendre la baguette "+this.toString()+" déjà prise par "+this.philosophe.getName());
            return false;
        }
    }
    // Retourne faux si la baguette était libre ou si le mauvais philosophe tente de poser la baguette
    // Retourne vrai si la baguette n'était pas libre, la fait passer en état "libre"
    public boolean release(Philosopher philosophe){
        if(!iAmFree){
            if(philosophe == this.philosophe){
                iAmFree = true;
                System.out.println("*"+this.toString()+" lâchée par "+philosophe.getName()+"*");
                return true;
            }else{
                System.out.println(philosophe.getName()+" a essayé de lâcher la baguette "+this.toString()+" tenue par "+this.philosophe.getName()+" !");
                return false;
            }
        }else{
            System.out.println(philosophe.getName()+" a essayé de lâcher la baguette "+this.toString()+" libre !");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
