package com.mx.cbtis.gestor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.mx.cbtis.gestor.controller.AsignacionesController;
import com.mx.cbtis.gestor.controller.ComentariosController;
import com.mx.cbtis.gestor.controller.ProyectosController;
import com.mx.cbtis.gestor.controller.TareasController;
import com.mx.cbtis.gestor.controller.UsuarioController;
import com.mx.cbtis.gestor.dto.AsignacionesDTO;
import com.mx.cbtis.gestor.dto.ComentariosDTO;
import com.mx.cbtis.gestor.dto.ProyectosDTO;
import com.mx.cbtis.gestor.dto.TareasDTO;
import com.mx.cbtis.gestor.dto.UsuarioDTO;
import com.mx.cbtis.gestor.repository.AsignacionesRepository;
import com.mx.cbtis.gestor.repository.ComentariosRepository;
import com.mx.cbtis.gestor.repository.ProtectosRepository;
import com.mx.cbtis.gestor.repository.TareasRepository;
import com.mx.cbtis.gestor.repository.UsuarioRepository;

class Ejercicio5MyApiGestorApplicationTests {

	@Test
	void contextLoadsAndDtosWork() {
		Ejercicio5MyApiGestorApplication app = new Ejercicio5MyApiGestorApplication();
		assertNotNull(app);

		AsignacionesDTO adto = new AsignacionesDTO();
		adto.setId_asignacion(1);
		adto.setId_usuario(2);
		adto.setId_tarea(3);
		adto.setFecha_asignacion("2026-10-22");
		assertEquals(1, adto.getId_asignacion());
		assertEquals(2, adto.getId_usuario());
		assertEquals(3, adto.getId_tarea());
		assertEquals("2026-10-22", adto.getFecha_asignacion());
		assertNotNull(new AsignacionesDTO(1, 2, 3, "2026-10-22").toEntity());

		ComentariosDTO cdto = new ComentariosDTO();
		cdto.setId_comentario(1);
		cdto.setId_usuario("2");
		cdto.setId_tarea(3);
		cdto.setTexto_comentario("Ok");
		cdto.setFecha_hora("2026-10-22");
		assertEquals(1, cdto.getId_comentario());
		assertEquals("2", cdto.getId_usuario());
		assertEquals(3, cdto.getId_tarea());
		assertEquals("Ok", cdto.getTexto_comentario());
		assertEquals("2026-10-22", cdto.getFecha_hora());
		assertNotNull(new ComentariosDTO(1, "2", 3, "Ok", "2026-10-22").toEntity());

		ProyectosDTO pdto = new ProyectosDTO();
		pdto.setId_proyecto(1);
		pdto.setNombre("P");
		pdto.setDescripcion("D");
		pdto.setFecha_inicio("2026-01-01");
		pdto.setFecha_finalizacion("2026-02-01");
		pdto.setEstado_proyecto("Activo");
		pdto.setFondo("F");
		assertEquals(1, pdto.getId_proyecto());
		assertEquals("P", pdto.getNombre());
		assertEquals("D", pdto.getDescripcion());
		assertEquals("2026-01-01", pdto.getFecha_inicio());
		assertEquals("2026-02-01", pdto.getFecha_finalizacion());
		assertEquals("Activo", pdto.getEstado_proyecto());
		assertEquals("F", pdto.getFondo());
		assertNotNull(new ProyectosDTO(1, "P", "D", "2026-01-01", "2026-02-01", "Activo", "F").toEntity());

		TareasDTO tdto = new TareasDTO();
		tdto.setId_tarea(1);
		tdto.setNombre("T");
		tdto.setDescripcion("D");
		tdto.setFecha_vencimiento("2026-01-01");
		tdto.setLista("pendientes");
		tdto.setEstado("danger");
		tdto.setId_proyecto(1);
		assertEquals(1, tdto.getId_tarea());
		assertEquals("T", tdto.getNombre());
		assertEquals("D", tdto.getDescripcion());
		assertEquals("2026-01-01", tdto.getFecha_vencimiento());
		assertEquals("pendientes", tdto.getLista());
		assertEquals("danger", tdto.getEstado());
		assertEquals(1, tdto.getId_proyecto());
		assertNotNull(new TareasDTO(1, "T", "D", "2026-01-01", "pendientes", "danger", 1).toEntity());

		UsuarioDTO udto = new UsuarioDTO();
		udto.setId_usuario(1);
		udto.setNombre("U");
		udto.setCorreo_electronico("u@test.com");
		udto.setContrasena("1234");
		udto.setRol("Admin");
		udto.setImagen_usuario("img.png");
		assertEquals(1, udto.getId_usuario());
		assertEquals("U", udto.getNombre());
		assertEquals("u@test.com", udto.getCorreo_electronico());
		assertEquals("1234", udto.getContrasena());
		assertEquals("Admin", udto.getRol());
		assertEquals("img.png", udto.getImagen_usuario());
		assertNotNull(new UsuarioDTO(1, "U", "u@test.com", "1234", "Admin", "img.png").toEntity());

		AsignacionesController ac = new AsignacionesController(
				mock(AsignacionesRepository.class), mock(UsuarioRepository.class), mock(TareasRepository.class));
		assertEquals(HttpStatus.BAD_REQUEST, ac.addAsignacionEndpoint(null).getStatusCode());
		assertEquals(HttpStatus.NOT_FOUND, ac.addAsignacionEndpoint(adto).getStatusCode());
		assertEquals(1, ac.updateAsignacionEndpoint(adto));
		assertEquals(0, ac.updateAsignacionEndpoint(null));
		assertEquals(1, ac.deleteAsignacionEndpoint(adto));
		assertEquals(0, ac.deleteAsignacionEndpoint(null));

		ComentariosController cc = new ComentariosController(
				mock(ComentariosRepository.class), mock(TareasRepository.class));
		assertNotNull(cc.getComentarioEndpoint(cdto));
		assertNotNull(cc.getComentarioEndpoint(null));
		assertEquals(HttpStatus.BAD_REQUEST, cc.addComentarioEndpoint(null).getStatusCode());
		assertEquals(HttpStatus.NOT_FOUND, cc.addComentarioEndpoint(cdto).getStatusCode());
		assertEquals(1, cc.updateComentarioEndpoint(cdto));
		assertEquals(0, cc.updateComentarioEndpoint(null));
		assertEquals(1, cc.deleteComentarioEndpoint(cdto));
		assertEquals(0, cc.deleteComentarioEndpoint(null));

		ProyectosController pc = new ProyectosController(mock(ProtectosRepository.class));
		assertEquals(1, pc.addProyectoEndpoint(pdto));
		assertEquals(0, pc.addProyectoEndpoint(null));
		assertEquals(1, pc.updateProyectoEndpoint(pdto));
		assertEquals(0, pc.updateProyectoEndpoint(null));
		assertEquals(HttpStatus.NOT_FOUND, pc.deleteProyectoEndpoint(pdto).getStatusCode());
		assertEquals(HttpStatus.NOT_FOUND, pc.deleteProyectoEndpoint(null).getStatusCode());

		TareasController tc = new TareasController(mock(TareasRepository.class), mock(ProtectosRepository.class));
		assertNotNull(tc.getTareaEndpoint(tdto));
		assertNotNull(tc.getTareaEndpoint(null));
		assertEquals(HttpStatus.BAD_REQUEST, tc.addTareasEndpoint(null).getStatusCode());
		assertEquals(HttpStatus.NOT_FOUND, tc.addTareasEndpoint(tdto).getStatusCode());
		assertEquals(1, tc.updateTareasEndpoint(tdto));
		assertEquals(0, tc.updateTareasEndpoint(null));
		assertEquals(HttpStatus.NOT_FOUND, tc.deleteTareasEndpoint(tdto).getStatusCode());
		assertEquals(HttpStatus.NOT_FOUND, tc.deleteTareasEndpoint(null).getStatusCode());

		UsuarioController uc = new UsuarioController(mock(UsuarioRepository.class));
		assertEquals(HttpStatus.BAD_REQUEST, uc.getUsuarioLoginEndpoint(null).getStatusCode());
		assertEquals(HttpStatus.UNAUTHORIZED, uc.getUsuarioLoginEndpoint(udto).getStatusCode());
		assertEquals(HttpStatus.BAD_REQUEST, uc.addUsuarioEndpoint(null).getStatusCode());
		assertEquals(HttpStatus.OK, uc.addUsuarioEndpoint(udto).getStatusCode());
		assertEquals(1, uc.updateUsuarioEndpoint(udto));
		assertEquals(0, uc.updateUsuarioEndpoint(null));
		assertEquals(1, uc.deleteUsuarioEndpoint(udto));
		assertEquals(0, uc.deleteUsuarioEndpoint(null));
	}
}
