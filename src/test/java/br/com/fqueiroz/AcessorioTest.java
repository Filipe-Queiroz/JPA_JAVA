package test.java.br.com.fqueiroz;

import main.java.br.com.fqueiroz.domain.Carro;
import main.java.br.com.fqueiroz.domain.Marca;
import main.java.br.com.fqueiroz.domain.Acessorio;
import main.java.dao.*;
import org.junit.Test;


import static org.junit.Assert.assertNotNull;

public class AcessorioTest {

    private IAcessorioDao acessorioDao;

    private IMarcaDao marcaDao;

    private ICarroDao carroDao;


    public AcessorioTest() {
        acessorioDao = new AcessorioDao();
        marcaDao = new MarcaDao();
        carroDao = new CarroDao();
    }

    @Test
    public void cadastrar() {
        Marca marca =  criarMarca("A1");
        Carro carro = criarCarro("A1");


        Acessorio ace = new Acessorio();
        ace.setCodigo("A");
        ace.setNome("Manopla de Cambio");
        ace.setStatus("COMPRADO");
        ace.setValor(2000d);
        ace.setMarca(marca);
        ace.setCarro(carro);
        carro.setAcessorio(ace);
        acessorioDao.cadastrar(ace);

        assertNotNull(ace);
        assertNotNull(ace.getId());
    }

    private Carro criarCarro(String codigo) {
        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setNome("911 Carrera");
        carro.setDescricao("Cor: amarelo");
        return carroDao.cadastrar(carro);
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Porsche");
        return marcaDao.cadastrar(marca);
    }
}
