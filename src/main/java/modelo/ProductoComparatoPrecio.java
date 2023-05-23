package modelo;

import java.util.Comparator;

public class ProductoComparatoPrecio implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		int i=0;
		if(o1.getPrecio()<o2.getPrecio()) {
			i=-1;
		}
		if(o1.getPrecio()>o2.getPrecio()) {
			i=1;
		}
		if(o1.getPrecio()==o2.getPrecio()) {
			i=0;
		}
		return i;
	}

}
