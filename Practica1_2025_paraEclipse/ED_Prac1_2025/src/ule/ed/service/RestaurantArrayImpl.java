package ule.ed.service;

import java.util.List;
import java.util.ArrayList;

public class RestaurantArrayImpl implements IRestaurant {

	// ATRIBUTOS
	
	private String name;
	private int nTables;
	private int maxCapacity; // máximo número de clientes admitidos
	private int nClients; // contador de clientes actuales en el restaurante

	private int discount;    // Descuento a aplicar (ejemplo: 10%)

	private Service[] tables; // array de servicios (cada servicio se corresponde con una mesa)
	                          


	// CONSTRUCTOR

	public RestaurantArrayImpl(String name, int nTables,int aforoMax, int discount){ 
		// Debe crear el array de mesas con todas las posiciones a null
		this.tables=new Service[nTables];
		this.name=name;
		this.maxCapacity=aforoMax;
		this.discount=discount;
		this.nClients=0;
		
	}



	@Override
	public String getName() {
		return this.name;
		
	}



	@Override
	public int getMaxCapacity() {
		return this.maxCapacity;
	}



	@Override
	public int getNumberOfChildren() {
		int contadorChildren=0;
		for(int i=0;i<this.nTables;i++){
			
			contadorChildren+=tables[i].getNChildren();
		}
		
		return contadorChildren;
	}



	@Override
	public int getNumberOfPeople() {
		return this.maxCapacity-this.nClients;
	}



	@Override
	public int getActualCapacity() {
		return this.nClients;
	}



	@Override
	public int getNumberTablesOccupied() {
		int contador=0;
		for(int i=0;i<this.nTables;i++){
			
			if(tables[i]!=null) {
				contador++;
			}
			
		}
		return contador;
	}



	@Override
	public int getNumberOfEmptyTables() {
		return this.nTables-this.getNumberTablesOccupied();
	}



	@Override
	public int getNumberOfTablesWithChildren() {
		int contador=0;
		for(int i=0;i<this.nTables;i++){
			
			if(tables[i].getNChildren()!=0) {
				contador++;
			}
			
		}
		
		return contador;
	}



	@Override
	public List<Integer> getNumbersOfEmptyTables() {
		List<Integer> lista = new ArrayList<>();
	    for (int i = 0; i < this.tables.length; i++) {
	        if (this.tables[i] == null) {
	            lista.add(i + 1);
	        }
	    }
		
		return lista;
	}



	@Override
	public Service getService(int ntable) {
		
		return this.tables[ntable-1];
	}



	@Override
	public void addDishToTable(int nTable, String name, double price, int count) {
		this.tables[nTable-1].addDishToTable(name, price, count);
	
	}



	@Override
	public double getFinalPrice(int ntable) {
		return this.tables[ntable-1].getTotalService();
		
	}



	@Override
	public double getFinalPriceRestaurant() {
		double precio=0;
		for(int i=0;i<this.tables.length;i++) {
			precio+=this.tables[i].getTotalService();
		}
		return precio;
    }



	@Override
	public boolean emptyTable(int nTable) {
		
		return false;
	}



	@Override
	public int occupyTable(int nPeople, int nChildren) {
		return 0;
	}
	
	@Override
	public boolean occupyTable(int nTable, int nPeople, int nChildren) {
		return false;
		
	}
	
}