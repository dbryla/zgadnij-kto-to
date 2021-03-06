:- dynamic(
    xpozytywne/2,
    xnegatywne/2).

load_library("QuestionLibrary").

osoba_jest(robert_lewandowski) :- pozytywne(czy, to_meżczyzna),
                                  jest_to(polak),
                                  jest_to(pilkarz).

osoba_jest(iker_casillas) :- pozytywne(czy, to_meżczyzna),
                             jest_to(obcokrajowiec), 
                             jest_to(pilkarz).

osoba_jest(ayrton_senna) :- pozytywne(czy, to_meżczyzna),
                            jest_to(obcokrajowiec), 
                            jest_to(rajdowiec),
                            jest_to(martwy).

osoba_jest(robert_kubica) :- pozytywne(czy, to_meżczyzna),
                             jest_to(polak), 
                             jest_to(rajdowiec).


osoba_jest(bartosz_kurek) :- pozytywne(czy, to_meżczyzna),
                             jest_to(polak),
                             jest_to(siatkarz).


osoba_jest(jennifer_aniston) :- negatywne(czy, to_meżczyzna),
                                jest_to(obcokrajowiec),
                                jest_to(aktor),
                                jest_to(mlody_aktor).

osoba_jest(meryl_streep) :- negatywne(czy, to_meżczyzna),
                            jest_to(obcokrajowiec), 
                            jest_to(aktor).

osoba_jest(daniel_craig) :- jest_to(bond), jest_to(mlody_aktor).

osoba_jest(sean_connery) :- jest_to(bond).

osoba_jest(andrzej_grabowski) :- pozytywne(czy, to_meżczyzna),
                                 jest_to(polak), 
                                 jest_to(aktor),
                                 jest_to(kiepski).

osoba_jest(jerzy_stuhr) :- pozytywne(czy, to_meżczyzna),
                           jest_to(polak), 
                           jest_to(aktor).

osoba_jest(jim_carrey) :- pozytywne(czy, to_meżczyzna),
                          jest_to(obcokrajowiec),
                          jest_to(komediant).

osoba_jest(jason_statham) :- pozytywne(czy, to_meżczyzna),
                             jest_to(obcokrajowiec), 
                             jest_to(aktor_z_filmu_akcji).

osoba_jest(robert_de_niro) :- pozytywne(czy, to_meżczyzna),
                              jest_to(obcokrajowiec), 
                              jest_to(aktor).

osoba_jest(agnieszka_dygant) :- negatywne(czy, to_meżczyzna),
                                jest_to(polak), 
                                jest_to(aktor_serlialowy).

osoba_jest(alicja_bachleda_curus) :- negatywne(czy, to_meżczyzna),
                                     jest_to(polak), 
                                     jest_to(aktor).

osoba_jest(lady_gaga) :- negatywne(czy, to_meżczyzna),
                         jest_to(obcokrajowiec),
                         jest_to(wokalista),
                         jest_to(ekscentryk).

osoba_jest(eminem) :- pozytywne(czy, to_meżczyzna),
                      jest_to(obcokrajowiec),
                      jest_to(raper).

osoba_jest(shakira) :- negatywne(czy, to_meżczyzna),
                       jest_to(obcokrajowiec),
                       jest_to(wokalista).

osoba_jest(fryderyk_chopin) :- pozytywne(czy, to_meżczyzna),
                               jest_to(polak),
                               jest_to(kompozytor),
                               jest_to(pianista),
                               jest_to(martwy).

osoba_jest(krzysztof_penderecki) :- pozytywne(czy, to_meżczyzna),
                                    jest_to(polak),
                                    jest_to(kompozytor).


jest_to(polak) :- pozytywne(czy, urodziła_się_w_Polsce).
jest_to(obcokrajowiec) :- \+jest_to(polak).
jest_to(pilkarz) :- jest_to(sport_druzynowy), pozytywne(czy, kopie_piłke).
jest_to(siatkarz) :- jest_to(sport_druzynowy), negatywne(czy, kopie_piłke).
jest_to(sport_druzynowy) :- pozytywne(czy, uprawia_sport), pozytywne(czy, uprawia_sport_drużynowy).
jest_to(rajdowiec) :-  pozytywne(czy, uprawia_sport), negatywne(czy, uprawia_sport_drużynowy).
jest_to(aktor) :- pozytywne(czy, gra_w_filmach).
jest_to(bond) :-  pozytywne(czy, to_meżczyzna), jest_to(obcokrajowiec), jest_to(aktor), pozytywne(czy, grała_Bonda).
jest_to(artysta_muzyczny) :- pozytywne(czy, zajmuje_się_muzyką).
jest_to(raper) :- jest_to(artysta_muzyczny), pozytywne(czy, rapuje).
jest_to(kompozytor) :- jest_to(artysta_muzyczny), pozytywne(czy, komponuje).
jest_to(wokalista) :- jest_to(artysta_muzyczny), pozytywne(czy, śpiewa).
jest_to(mlody_aktor) :- jest_to(aktor), pozytywne(czy, ma_mniej_niż_50_lat).
jest_to(kiepski) :- pozytywne(czy, grała_w_Świat_według_kiepskich).
jest_to(komediant) :- jest_to(aktor), pozytywne(czy, gra_w_komediach).
jest_to(aktor_z_filmu_akcji) :- jest_to(aktor), pozytywne(czy, gra_w_filmach_akcji).
jest_to(pianista) :- jest_to(artysta_muzyczny), pozytywne(czy, gra_na_pianinie).
jest_to(martwy) :- pozytywne(czy, nie_żyje).
jest_to(aktor_serlialowy) :- jest_to(aktor), pozytywne(czy, gra_w_serialach).
jest_to(ekscentryk) :- pozytywne(czy, ma_ekscentryczne_ubiory).


pozytywne(X,Y) :- xpozytywne(X,Y), !.

pozytywne(X,Y) :- \+xnegatywne(X,Y), pytaj(X,Y,tak).

negatywne(X,Y) :- xnegatywne(X,Y), !.

negatywne(X,Y) :- \+xpozytywne(X,Y), pytaj(X,Y,nie).

pytaj(X,Y,tak) :- !, ask(X, Y, Reply),
                    pamietaj(X,Y,Reply),
                    (Reply = 't').
                    
pytaj(X,Y,nie) :- !, ask(X, Y, Reply),
                    pamietaj(X,Y,Reply),
                    (Reply = 'n').
                    
pamietaj(X,Y,'t') :- assertz(xpozytywne(X,Y)).

pamietaj(X,Y,'n') :- assertz(xnegatywne(X,Y)).

wyczysc_fakty :-    retractall(xpozytywne(_,_)),
                    retractall(xnegatywne(_,_)).

wykonaj :- osoba_jest(X), !,
            announcePerson(X),
            wyczysc_fakty.
            
wykonaj :- printLose,
            wyczysc_fakty.
