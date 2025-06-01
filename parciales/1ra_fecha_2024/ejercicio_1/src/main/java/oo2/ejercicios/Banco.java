package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private List<Prestamo> prestamos;
    private double interesSimple;

    public Banco(double interesSimple) {
        clientes = new ArrayList<Cliente>();
        prestamos = new ArrayList<>();
        this.interesSimple = interesSimple;
    }

    public Cliente registrarCliente(String nombre, double salarioMensual) {
        Cliente cliente = new Cliente(nombre, salarioMensual);
        clientes.add(cliente);
        return cliente;
    }

    public Simple SolicitarPrestamoSimple(int cantCuotas, double monto, Cliente cliente) {
        Simple prestamoSimple = new Simple(cliente,monto,cantCuotas,interesSimple);
        this.prestamos.add(prestamoSimple);
        return prestamoSimple;


    }

    public UVA solicitarPrestamoUVA(int cantCuotas, double monto, Cliente cliente) {
        UVA prestamoUVA = new UVA(cliente,monto,cantCuotas);
        this.prestamos.add(prestamoUVA);
        return prestamoUVA;
    }

}
