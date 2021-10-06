package Modelo;

public class caixa 
{
    private int cod;
    private double saldoI;
    private double saldoF;
    private char status;
    private mov_Caixa mc;

    public caixa() {
    }

    public caixa(int cod, double saldoI, double saldoF, char status, mov_Caixa mc) {
        this.cod = cod;
        this.saldoI = saldoI;
        this.saldoF = saldoF;
        this.status = status;
        this.mc = mc;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getSaldoI() {
        return saldoI;
    }

    public void setSaldoI(double saldoI) {
        this.saldoI = saldoI;
    }

    public double getSaldoF() {
        return saldoF;
    }

    public void setSaldoF(double saldoF) {
        this.saldoF = saldoF;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public mov_Caixa getMc() {
        return mc;
    }

    public void setMc(mov_Caixa mc) {
        this.mc = mc;
    }
    
    
}
