package ru.geekbrains.tests.lession_1_homework

import org.junit.Assert
import org.junit.Test
import ru.geekbrains.tests.lession_1_homework.core.EmailValidator

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(null))
    }

    /** Пункт 1 ДЗ: Негативные тесты */ //region
    @Test
    fun emailValidator_EmptyDomain_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("avk@"))
    }
    @Test
    fun emailValidator_TwoAT_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("avk@@yandex.ru"))
    }
    @Test
    fun emailValidator_EmptyAT_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("avkyandex.ru"))
    }
    @Test
    fun emailValidator_AddRightSlash_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("/avk@yandex.ru"))
    }
    @Test
    fun emailValidator_AddLeftSlash_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("\\avk@yandex.ru"))
    }
    @Test
    fun emailValidator_AddSpaceInAddress_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(" avk@yandex.ru"))
    }
    @Test
    fun emailValidator_AddSpaceInDomain_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("avk@yandex .ru"))
    }
    @Test
    fun emailValidator_NotFullyDomain_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("avk@.ru"))
    }
    //endregion
}