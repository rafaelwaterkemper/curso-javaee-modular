/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Usuario;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class UsuarioService {

    @Inject
    private Repository<Usuario> repository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void saveUser(Usuario usuario) {
        repository.persist(usuario);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Usuario update(Usuario usuario) {
        return repository.merge(usuario);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Usuario usuario) {
        repository.remove(usuario);
    }

    public Usuario findOne(long id) {
        return repository.findOne(id);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

}
