package Modelo;

import java.util.Date;

public class acerto 
{
    private int cod;
    private Date data;
    private double valor;
    private char tipo;
    private String motivo;

    public acerto() {
    }

    public acerto(int cod, Date data, double valor, char tipo, String motivo) {
        this.cod = cod;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.motivo = motivo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}
