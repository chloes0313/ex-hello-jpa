package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager ();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            List<Member> resultList = em.createQuery("select m from Member m where m.username like '%chloe%'", Member.class)
                    .getResultList();

            for(Member mebmer : resultList) {
                System.out.println("member : "+mebmer.getUsername());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member fm1, Member fm2) {
        //실제객체가 넘어오는지 프록시로 넘어오는지 알 수 없음
        //System.out.println("fm1.class == fm2.class : " + (fm1.getClass() == fm2.getClass()));
        System.out.println("fm1 instanceof Member : " + (fm1 instanceof Member));
        System.out.println("fm2 instanceof Member : " + (fm2 instanceof Member));
    }

    private static void printMember (Member member) {
        System.out.println("member = " + member.getUsername());
    }

}
