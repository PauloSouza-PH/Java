package Funcoes;

public class Calculos {

    public String Rqc(double quadril, double abdomen) {
        return Double.toString(abdomen / quadril);
    }

    public String Crqc(double RCQ, int Idade, String Sexo) {

        String RESULT = null;

        if ("M".equals(Sexo)) {
            if (Idade > 20 && Idade < 29) {
                if (RCQ < 0.83) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.83 && RCQ < 0.88) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.88 && RCQ < 0.94) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.94) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 30 && Idade < 39) {
                if (RCQ < 0.84) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.84 && RCQ < 0.91) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.91 && RCQ < 0.96) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.96) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 40 && Idade < 49) {
                if (RCQ < 0.88) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.88 && RCQ < 0.95) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.95 && RCQ < 1.00) {
                    RESULT = "ALTO";
                } else if (RCQ > 1.00) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 50 && Idade < 59) {
                if (RCQ < 0.90) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.90 && RCQ < 0.96) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.96 && RCQ < 1.02) {
                    RESULT = "ALTO";
                } else if (RCQ > 1.02) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 60 && Idade < 69) {
                if (RCQ < 0.91) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.91 && RCQ < 0.98) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.99 && RCQ < 1.03) {
                    RESULT = "ALTO";
                } else if (RCQ > 1.03) {
                    RESULT = "MUITO ALTO";
                }

            }
        } else if ("F".equals(Sexo)) {
            if (Idade > 20 && Idade < 29) {
                if (RCQ < 0.71) {
                    RESULT = "BAIXO";

                } else if (RCQ > 0.71 && RCQ < 0.77) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.78 && RCQ < 0.82) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.82) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 30 && Idade < 39) {
                if (RCQ < 0.72) {
                    RESULT = "BAIXO";

                } else if (RCQ > 0.72 && RCQ < 0.78) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.79 && RCQ < 0.84) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.84) {
                    RESULT = "MUITO ALTO";
                }
            } else if (Idade > 40 && Idade < 49) {
                if (RCQ < 0.73) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.73 && RCQ < 0.79) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.80 && RCQ < 0.87) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.87) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 50 && Idade < 59) {
                if (RCQ < 0.74) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.74 && RCQ < 0.81) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.82 && RCQ < 0.88) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.88) {
                    RESULT = "MUITO ALTO";
                }

            } else if (Idade > 60 && Idade < 69) {
                if (RCQ < 0.76) {
                    RESULT = "BAIXO";
                } else if (RCQ > 0.76 && RCQ < 0.83) {
                    RESULT = "MODERADO";
                } else if (RCQ > 0.84 && RCQ < 0.90) {
                    RESULT = "ALTO";
                } else if (RCQ > 0.90) {
                    RESULT = "MUITO ALTO";
                }
            }
        }
        return RESULT;
    }

    public String Conicidade(double peso, double estatura, double cintura) {

        return Double.toString(cintura / (0.109 * (Math.sqrt(peso / estatura))));

    }

    public String SitGlicose(double Glicose) {
        String RESULT = null;
        if (Glicose < 100) {
            RESULT = "NORMAL";
        } else if (Glicose > 100 && Glicose < 129) {
            RESULT = "ELEVADO";
        } else if (Glicose > 140) {
            RESULT = "DIABETES";
        }
        return RESULT;
    }
}
