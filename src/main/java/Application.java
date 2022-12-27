import jakarta.ws.rs.ApplicationPath;

// bu sınıf jakarta 'ya özel
// /'dan sonra sınıflarımıza ulaşmasını sağlar.
@ApplicationPath("/")
public class Application extends jakarta.ws.rs.core.Application {
    // başka bir jax-rs teknolojisnde mesela resteasy mesela jersey mesela spring rest gibi
    // farklı bir konfigürasyon olur

    // classları reflectionlarla çalıştırılabilir hale getiriyor gibi düşün.
}
