package Persistencia;

import Modelo.caixa;
import Util.Banco;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class acertoDB 
{
    public void inserir(caixa c,int flag)
    {
        String SQL;
        try
        {
            Boolean ok = true;
            Banco.getCon().getConnect().setAutoCommit(false);
        
        if (flag == 0)
        {
            SQL = "INSERT INTO caixa(cai_cod, cai_saldoi, cai_saldof, cai_status) VALUES(#1, #2, #3, '#4')";
            SQL = SQL.replaceAll("#1", c.getCod()+"");
            SQL = SQL.replaceAll("#2", c.getSaldoI()+"");
            SQL = SQL.replaceAll("#3", c.getSaldoF()+"");
            SQL = SQL.replaceAll("#4", c.getStatus()+"");
            System.out.println("CAIXA:"+SQL);
            ok = Banco.getCon().manipular(SQL);
            if(ok)
            {
                Banco.getCon().getConnect().commit(); 
                Banco.getCon().getConnect().setAutoCommit(true);
            }
            else
            {
                Banco.getCon().getConnect().rollback(); 
                Banco.getCon().getConnect().setAutoCommit(true);
                System.out.println("ERRO AO CADASTRAR CAIXA");
            }
        }
        else   
        {
            SQL = "UPDATE caixa SET cai_saldoi = #1 , cai_saldof = #2, cai_status = #3 WHERE cai_cod = "+c.getCod();
            SQL = SQL.replaceAll("#1", c.getSaldoI()+"");
            SQL = SQL.replaceAll("#2", c.getSaldoF()+"");
            SQL = SQL.replaceAll("#3", c.getStatus()+"");
            System.out.println("CAIXA:"+SQL);
            ok = Banco.getCon().manipular(SQL);
            if(ok)
                {
                    Banco.getCon().getConnect().commit(); 
                    Banco.getCon().getConnect().setAutoCommit(true);
                }
                else
                {
                    Banco.getCon().getConnect().rollback();  
                    Banco.getCon().getConnect().setAutoCommit(true);
                    System.out.println("ERRO AO ATUALIZAR CAIXA");
                }
        }
        } catch (SQLException ex)
        {
            Logger.getLogger(caixaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
