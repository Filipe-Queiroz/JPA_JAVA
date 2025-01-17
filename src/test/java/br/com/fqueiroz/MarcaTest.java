package test.java.br.com.fqueiroz;

import main.java.br.com.fqueiroz.domain.Marca;
import main.java.dao.MarcaDao;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MarcaTest {

    private MarcaDao marcaDao;

    public MarcaTest() {
        marcaDao = new MarcaDao();
    }

    @Test
    public void Cadastrar() {
        Marca marca = new Marca();
        marca.setCodigo("A1");
        marca.setNome("Curso de Java Backend");
        marca = marcaDao.cadastrar(marca);

        assertNotNull(marca);
        assertNotNull(marca.getId());
    }
}
