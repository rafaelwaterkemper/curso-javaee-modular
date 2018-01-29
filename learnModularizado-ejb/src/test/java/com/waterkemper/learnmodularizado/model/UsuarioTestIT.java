package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.service.UsuarioService;
import com.waterkemper.learnmodularizado.util.AbstractService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class UsuarioTestIT {

    @Inject
    private UsuarioService service;

    @Deployment
    public static Archive<?> getArchive() {

        return ShrinkWrap.create(WebArchive.class, "testearquilian.war")
                .addPackage(Usuario.class.getPackage())
                .addPackage(UsuarioService.class.getPackage())
                .addPackage(AbstractService.class.getPackage())
                .addAsLibraries(getArchiveDependecies())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private static File[] getArchiveDependecies() {
        return Maven
                .resolver()
                .loadPomFromFile("pom.xml")
                .resolve("com.mysema.querydsl:querydsl-jpa:3.7.4")
                .withTransitivity()
                .asFile();
    }

    @Test
    public void deveValidarAGravacaoDoUsuarioNoBanco() {
        Usuario usuario = Usuario.Builder.create()
                .login("rafael")
                .senha("123456")
                .build();

        service.save(usuario);

        Usuario finded = service.findOne(1);
        assertEquals("rafael", finded.getLogin());
        assertEquals("123456", finded.getSenha());
    }

}