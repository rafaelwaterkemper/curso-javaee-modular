//package com.waterkemper.learnmodularizado.rest.resources;
//
//import com.waterkemper.learnmodularizado.model.Usuario;
//import com.waterkemper.learnmodularizado.service.UsuarioService;
//import org.jglue.cdiunit.CdiRunner;
//import org.jglue.cdiunit.ProducesAlternative;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import javax.enterprise.inject.Produces;
//import javax.inject.Inject;
//
//import static org.mockito.Matchers.any;
//
//@RunWith(CdiRunner.class)
//public class UsuarioResourceTest {
//
//    @Inject
//    private UsuarioResource resource;
//
//    @Mock
//    @Produces
//    @ProducesAlternative
//    private UsuarioService service;
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void validaGetAllUsuarios() {
//        Usuario usuarioMock = Mockito.mock(Usuario.class);
//        Mockito.when(service.findOne(any(Integer.class))).thenReturn(usuarioMock);
//
//        javax.ws.rs.core.Response response = resource.findOne(1);
//        System.out.println(response.getEntity());
//    }
//
//
//}