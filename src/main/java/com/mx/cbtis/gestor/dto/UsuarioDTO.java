package com.mx.cbtis.gestor.dto;

import com.mx.cbtis.gestor.modelo.Usuario;

@SuppressWarnings({"java:S116", "java:S100"})
public class UsuarioDTO {

	private Integer id_usuario;
	private String nombre;
	private String correo_electronico;
	private String contrasena;
	private String rol;
	private String imagen_usuario;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Integer idUsuario, String nombre, String correoElectronico, String contrasena, String rol,
			String imagenUsuario) {
		super();
		this.id_usuario = idUsuario;
		this.nombre = nombre;
		this.correo_electronico = correoElectronico;
		this.contrasena = contrasena;
		this.rol = rol;
		this.imagen_usuario = imagenUsuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer idUsuario) {
		this.id_usuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correoElectronico) {
		this.correo_electronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getImagen_usuario() {
		return imagen_usuario;
	}

	public void setImagen_usuario(String imagenUsuario) {
		this.imagen_usuario = imagenUsuario;
	}

	public Usuario toEntity() {
		return new Usuario(this.id_usuario, this.nombre, this.correo_electronico, this.contrasena, this.rol,
				this.imagen_usuario);
	}
}
