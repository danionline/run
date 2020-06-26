package categorias;

import java.util.ArrayList;

import producto.CrudAble;

public interface CateoriaDAO extends CrudAble<Categoria> {

	ArrayList<Categoria> getAll();

}
