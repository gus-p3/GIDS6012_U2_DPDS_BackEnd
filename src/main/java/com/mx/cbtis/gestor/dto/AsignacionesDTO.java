package com.mx.cbtis.gestor.dto;

import com.mx.cbtis.gestor.modelo.Asignaciones;

@SuppressWarnings({"java:S116", "java:S100"})
public class AsignacionesDTO {

	private Integer id_asignacion;
	private Integer id_usuario;
	private Integer id_tarea;
	private String fecha_asignacion;

	public AsignacionesDTO() {
		super();
	}

	public AsignacionesDTO(Integer idAsignacion, Integer idUsuario, Integer idTarea, String fechaAsignacion) {
		super();
		this.id_asignacion = idAsignacion;
		this.id_usuario = idUsuario;
		this.id_tarea = idTarea;
		this.fecha_asignacion = fechaAsignacion;
	}

	public Integer getId_asignacion() {
		return id_asignacion;
	}

	public void setId_asignacion(Integer idAsignacion) {
		this.id_asignacion = idAsignacion;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer idUsuario) {
		this.id_usuario = idUsuario;
	}

	public Integer getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(Integer idTarea) {
		this.id_tarea = idTarea;
	}

	public String getFecha_asignacion() {
		return fecha_asignacion;
	}

	public void setFecha_asignacion(String fechaAsignacion) {
		this.fecha_asignacion = fechaAsignacion;
	}

	public Asignaciones toEntity() {
		return new Asignaciones(this.id_asignacion, this.id_usuario, this.id_tarea, this.fecha_asignacion);
	}
}
