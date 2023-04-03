package com.carbuddy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    NOT_FOUND(2004,"İlgili veri, veritabanında bulunamadı",HttpStatus.NOT_FOUND),
    BAD_REQUEST(4000,"Geçersiz istek ya da parametre",HttpStatus.BAD_REQUEST),
    ERROR(9000,"Beklenmeyen bir hata oluştu. Lütfen tekrar deneyin",HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND_COLOR(2002,"Bu  renk veritabanında tanımlı değildir.",HttpStatus.NOT_FOUND),
    NOT_FOUND_BRAND(2003,"Bu  marka veritabanında tanımlı değildir.",HttpStatus.NOT_FOUND),
    NOT_FOUND_PRICE(2004,"Bu fiyatın altında bir araba veritabanında tanımlı değildir.",HttpStatus.NOT_FOUND),
    NOT_FOUND_RENTAL(2005,"Kiralanmış bir araba veritabanında tanımlı değildir",HttpStatus.NOT_FOUND),
    NOT_FOUND_RENT(2006,"İstenilen araba veya müşteri veri tabanına kayıtlı değildir.",HttpStatus.BAD_REQUEST),
    FOUND_COLOR(2005,"Bu renk veritabanında zaten kayıtlıdır.",HttpStatus.BAD_REQUEST),
    FOUND_BRAND(2006,"Bu marka veritabanında zaten katılıdır.", HttpStatus.BAD_REQUEST)
            ;


    int code;
    String message;
    HttpStatus httpStatus;
}
