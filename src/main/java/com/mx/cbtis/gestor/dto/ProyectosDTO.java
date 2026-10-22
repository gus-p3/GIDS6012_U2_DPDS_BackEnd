package com.mx.cbtis.gestor.dto;

import com.mx.cbtis.gestor.modelo.Proyectos;

@SuppressWarnings({"java:S116", "java:S100"})
public class ProyectosDTO {

	private Integer id_proyecto;
	private String nombre;
	private String descripcion;
	private String fecha_inicio;
	private String fecha_finalizacion;
	private String estado_proyecto;
	private String fondo;

	public ProyectosDTO() {
		super();
	}

	public ProyectosDTO(Integer idProyecto, String nombre, String descripcion, String fechaInicio,
			String fechaFinalizacion, String estadoProyecto, String fondo) {
		super();
		this.id_proyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fechaInicio;
		this.fecha_finalizacion = fechaFinalizacion;
		this.estado_proyecto = estadoProyecto;
		this.fondo = fondo;
	}

	public Integer getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(Integer idProyecto) {
		this.id_proyecto = idProyecto;
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

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fechaInicio) {
		this.fecha_inicio = fechaInicio;
	}

	public String getFecha_finalizacion() {
		return fecha_finalizacion;
	}

	public void setFecha_finalizacion(String fechaFinalizacion) {
		this.fecha_finalizacion = fechaFinalizacion;
	}

	public String getEstado_proyecto() {
		return estado_proyecto;
	}

	public void setEstado_proyecto(String estadoProyecto) {
		this.estado_proyecto = estadoProyecto;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public Proyectos toEntity() {
		return new Proyectos(this.id_proyecto, this.nombre, this.descripcion, this.fecha_inicio,
				this.fecha_finalizacion, this.estado_proyecto, this.fondo);
	}
}
