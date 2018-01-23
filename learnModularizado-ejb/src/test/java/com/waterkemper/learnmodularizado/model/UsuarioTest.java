package com.waterkemper.learnmodularizado.model;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(CdiRunner.class)
public class UsuarioTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void validaTextoNoUsuario() {
        Usuario usuario = Usuario.Builder.create()
                .login("rafaelmw")
                .senha("123456")
                .build();

        assertEquals("rafaelmw", usuario.getLogin());
        assertEquals("123456", usuario.getSenha());
    }

}