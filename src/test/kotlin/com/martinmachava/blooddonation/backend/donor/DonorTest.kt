package com.martinmachava.blooddonation.backend.donor

import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase

internal class DonorTest: BaseCoreFunctionalTestCase() {

    //TEST DONOR ENTITY
    /*@Test
    fun createValidUser_saveUser_userSaved() {
        doInHibernate(Supplier { sessionFactory() }, Consumer { session: Session ->
            val expectedUser = User(
                    "test.user@email.com",
                    "testPASSWORD",
                    "testFirstName",
                    "testLastName")
            session.persist(expectedUser)

            val actualUser: User = session.find(User::class.java, expectedUser.id)
            session.refresh(actualUser)

            assertThat(actualUser).isEqualTo(expectedUser)})
    }*/

}