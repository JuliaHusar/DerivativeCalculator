import java.util.ArrayList;
public class Term {
    private double coefficient;
    private String letterVariable;
    private double exponent;
    private ArrayList<Term> terms = new ArrayList();


    public Term() { //default constructor
        coefficient = 1;
        letterVariable = "n";
        exponent = 1;
    }

    public Term(double newCoefficient, String newLetterVariable, double newExponent) {
        this.coefficient = newCoefficient;
        this.letterVariable = newLetterVariable;
        this.exponent = newExponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String getLetterVariable() {

        return letterVariable;
    }

    public void setLetterVariable(String letterVariable) {
        this.letterVariable = letterVariable;
    }

    public double getExponent() {

        return exponent;
    }

    public void setExponent(double exponent) {

        this.exponent = exponent;
    }

    public void display(Term obj) { // displays term to output
        System.out.println(this.getCoefficient() + this.letterVariable + "^" +  this.getExponent());
    }
    public double calculateDerivativeCoefficient(){ // calculates new coefficient
        return this.getCoefficient()*this.getExponent();
    }
    public double calculateDerivativeExponent(){ // calculates new exponent
        return this.getExponent() - 1;
    }

    public void createNewDerivative(Term obj){ // creates the new term in the derivative and adds to term arraylist
        switch ((int)this.calculateDerivativeExponent()){
            case 1: // If exponent is 1,then the exponent will be hidden
                System.out.println((int)(this.calculateDerivativeCoefficient()) + this.getLetterVariable());
                terms.add(this);
                break;
            case 0: // If exponent is 0 then it will only print out the coefficient because n will be 1
                System.out.println((int)(this.calculateDerivativeCoefficient()));
                terms.add(this);
                break;
            default: // Prints out the whole term
                System.out.println((int)(this.calculateDerivativeCoefficient()) + this.getLetterVariable() + "^" + this.calculateDerivativeExponent());
                terms.add(this);
            break;
        }
    }
    public <terms> void displayArrayListHex(Term obj){ // displays the hexadecimal arraylist object
        for (int i = 0; i < terms.size(); i++) {
            terms.get(i).display(obj);
        }
    }


    public void displayArrayList(Term obj){

    }
}
