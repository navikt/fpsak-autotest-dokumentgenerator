package no.nav.foreldrepenger.autotest.dokumentgenerator.inntektsmelding.erketyper;

import java.math.BigDecimal;

import no.nav.foreldrepenger.autotest.dokumentgenerator.foreldrepengesoknad.json.modell.Fødselsnummer;
import no.nav.foreldrepenger.autotest.dokumentgenerator.foreldrepengesoknad.json.modell.felles.Orgnummer;
import no.nav.foreldrepenger.autotest.dokumentgenerator.inntektsmelding.builders.InntektsmeldingBuilder;
import no.nav.inntektsmelding.xml.kodeliste._20180702.YtelseKodeliste;
import no.nav.inntektsmelding.xml.kodeliste._20180702.ÅrsakInnsendingKodeliste;

public class InntektsmeldingSvangerskapspengerErketyper {

    private InntektsmeldingSvangerskapspengerErketyper() {
    }

    public static InntektsmeldingBuilder lagSvangerskapspengerInntektsmelding(Fødselsnummer fnr, Integer beløp,
                                                                              Orgnummer orgnummer) {
        return lagSvangerskapspengerInntektsmelding(fnr.toString(), beløp, orgnummer.toString());
    }
    public static InntektsmeldingBuilder lagSvangerskapspengerInntektsmelding(String fnr, Integer beløp,
            String orgnummer) {
        return new InntektsmeldingBuilder()
                .medArbeidstakerFNR(fnr)
                .medBeregnetInntekt(BigDecimal.valueOf(beløp))
                .medYtelse(YtelseKodeliste.SVANGERSKAPSPENGER)
                .medAarsakTilInnsending(ÅrsakInnsendingKodeliste.NY)
                .medArbeidsgiver(orgnummer, "41925090")
                .medAvsendersystem("FS32", "1.0");
    }
}
