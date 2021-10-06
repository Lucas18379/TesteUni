package Modelo;

public class mov_Caixa 
{
    private int cod;
    private int cod_caixa;
    private int cod_ace;
    private double valor;
    private char tipo;

    public mov_Caixa() {
    }

    public mov_Caixa(int cod, int cod_caixa, int cod_ace, double valor, char tipo) {
        this.cod = cod;
        this.cod_caixa = cod_caixa;
        this.cod_ace = cod_ace;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod_caixa() {
        return cod_caixa;
    }

    public void setCod_caixa(int cod_caixa) {
        this.cod_caixa = cod_caixa;
    }

    public int getCod_ace() {
        return cod_ace;
    }

    public void setCod_ace(int cod_ace) {
        this.cod_ace = cod_ace;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
}
