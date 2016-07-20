/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.projeto3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AndrÃ©Luiz
 */
public class CasoTest {

    private static EntityManagerFactory emf;

    public CasoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("projeto3PU");
    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();

        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void buscarInformacaoDeMatriculaDeAluno() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Estudante estudante = (Estudante) em.createQuery("Select e from Estudante e Where e.id = :_idEstudante")
                .setParameter("_idEstudante", new Integer("2")).getSingleResult();

        System.out.println("Indentificação do Estudante");

        System.out.println("nome: " + estudante.getId());
        System.out.println("nome: " + estudante.getNome());
        System.out.println("nome: " + estudante.getStatus());

        System.out.println("Gerando Caso de Entrada (Problema)");

        Problema casoEntrada = new Problema();

        casoEntrada.setCurso(estudante.getCurso());

        System.out.println("Descrição do problema: Solicitação Matrícula");
        System.out.println("Curso: " + estudante.getCurso().getNome());
        System.out.println("Registro: " + (estudante.getMatriculaList().size() + 1) + "ª Matrícula");

        for (Matricula mat : estudante.getMatriculaList()) {
            Grupo grupo = new Grupo();
            casoEntrada.getGrupoList().add(grupo);
            casoEntrada.setQtdDisciplinas(casoEntrada.getQtdDisciplinas() + mat.getDisciplinaList().size());
            for (Disciplina d : mat.getDisciplinaList()) {
                casoEntrada.setCreditoTotal(casoEntrada.getCreditoTotal() + d.getCredito());
                casoEntrada.setCargaTotal(casoEntrada.getCargaTotal() + d.getCargaHoraria());
                casoEntrada.setSimilaridade(casoEntrada.getCargaTotal() * casoEntrada.getCreditoTotal() * casoEntrada.getQtdDisciplinas());
                grupo.getDisciplinaList().add(d);
                //System.out.println("disciplina: " + d.getNome());
            }
        }

        System.out.println("Quantidade de Disciplinas já Cursadas: " + casoEntrada.getQtdDisciplinas());
        System.out.println("Creditos: " + casoEntrada.getCreditoTotal());
        System.out.println("Carga Horária Total: " + casoEntrada.getCargaTotal());
        System.out.println("Similaridade: " + casoEntrada.getSimilaridade());

        Assert.assertTrue(true);

        for (Grupo grupo : casoEntrada.getGrupoList()) {
            for (Disciplina disc : grupo.getDisciplinaList()) {
                System.out.println(disc.getNome());
            }
        }
        
        System.out.println("Similaridade: " + casoEntrada.getSimilaridade());
        em.getTransaction().commit();
    }

}
