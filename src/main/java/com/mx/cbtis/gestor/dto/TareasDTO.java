package com.mx.cbtis.gestor.dto;

import com.mx.cbtis.gestor.modelo.Tareas;

@SuppressWarnings({"java:S116", "java:S100"})
public class TareasDTO {

	private Integer id_tarea;
	private String nombre;
	private String descripcion;
	private String fecha_vencimiento;
	private String lista;
	private String estado;
	private Integer id_proyecto;

	public TareasDTO() {
		super();
	}

	public TareasDTO(Integer idTarea, String nombre, String descripcion, String fechaVencimiento, String lista,
			String estado, Integer idProyecto) {
		super();
		this.id_tarea = idTarea;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_vencimiento = fechaVencimiento;
		this.lista = lista;
		this.estado = estado;
		this.id_proyecto = idProyecto;
	}

	public Integer getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(Integer idTarea) {
		this.id_tarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fechaVencimiento) {
		this.fecha_vencimiento = fechaVencimiento;
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(Integer idProyecto) {
		this.id_proyecto = idProyecto;
	}

	public Tareas toEntity() {
		return new Tareas(this.id_tarea, this.nombre, this.descripcion, this.fecha_vencimiento, this.lista,
				this.estado, this.id_proyecto);
	}
}
