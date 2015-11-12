:- dynamic
    xpozytywne/2,
    xnegatywne/2.


osoba_jest(robert_lewandowski) :- pozytywne(czy, mezczyzna),
                                  jest_to(polak),
                                  jest_to(pilkarz).

osoba_jest(iker_casillas) :- pozytywne(czy, mezczyzna), 
                             jest_to(obcokrajowiec), 
                             jest_to(pilkarz).

osoba_jest(ayrton_senna) :- pozytywne(czy, mezczyzna),
                            jest_to(obcokrajowiec), 
                            jest_to(rajdowiec),
                            jest_to(martwy).

osoba_jest(robert_kubica) :- pozytywne(czy, mezczyzna),
                             jest_to(polak), 
                             jest_to(rajdowiec).


osoba_jest(bartosz_kurek) :- pozytywne(czy, mezczyzna),
                             jest_to(polak),
                             jest_to(siatkarz).


osoba_jest(jennifer_aniston) :- negatywne(czy, mezczyzna),
                                jest_to(obcokrajowiec),
                                jest_to(aktor),
                                jest_to(mlody_aktor).

osoba_jest(meryl_streep) :- negatywne(czy, mezczyzna),
                            jest_to(obcokrajowiec), 
                            jest_to(aktor).

osoba_jest(daniel_craig) :- jest_to(bond), jest_to(mlody_aktor).

osoba_jest(sean_connery) :- jest_to(bond).

osoba_jest(andrzej_grabowski) :- pozytywne(czy, mezczyzna),
                                 jest_to(polak), 
                                 jest_to(aktor),
                                 jest_to(kiepski).

osoba_jest(jerzy_stuhr) :- pozytywne(czy, mezczyzna),
                           jest_to(polak), 
                           jest_to(aktor).

osoba_jest(jim_carrey) :- pozytywne(czy, mezczyzna),
                          jest_to(obcokrajowiec),
                          jest_to(komediant).

osoba_jest(jason_statham) :- pozytywne(czy, mezczyzna),
                             jest_to(obcokrajowiec), 
                             jest_to(aktor_z_filmu_akcji).

osoba_jest(robert_de_niro) :- pozytywne(czy, mezczyzna),
                              jest_to(obcokrajowiec), 
                              jest_to(aktor).

osoba_jest(agnieszka_dygant) :- negatywne(czy, mezczyzna),
                                jest_to(polak), 
                                jest_to(aktor_serlialowy).

osoba_jest(alicja_bachleda_curus) :- negatywne(czy, mezczyzna),
                                     jest_to(polak), 
                                     jest_to(aktor).

osoba_jest(lady_gaga) :- negatywne(czy, mezczyzna),
                         jest_to(obcokrajowiec),
                         jest_to(wokalista),
                         jest_to(ekscentryk).

osoba_jest(eminem) :- pozytywne(czy, mezczyzna),
                      jest_to(obcokrajowiec),
                      jest_to(raper).

osoba_jest(shakira) :- negatywne(mezczyzna),
                       jest_to(obcokrajowiec),
                       jest_to(wokalista).

osoba_jest(fryderyk_chopin) :- pozytywne(czy, mezczyzna),
                               jest_to(polak),
                               jest_to(kompozytor),
                               jest_to(pianista),
                               jest_to(martwy).

osoba_jest(krzysztof_penderecki) :- pozytywne(czy, mezczyzna),
                                    jest_to(polak),
                                    jest_to(kompozytor).


jest_to(polak) :- pozytywne(urodzila_sie, w_polsce).
jest_to(obcokrajowiec) :- \+jest_to(polak).
jest_to(pilkarz) :- jest_to(sport_druzynowy), pozytywne(czy, kopie_pilke).
jest_to(siatkarz) :- jest_to(sport_druzynowy), negatywne(czy, kopie_pilke).
jest_to(sport_druzynowy) :- pozytywne(uprawia, sport), pozytywne(czy, sport_druzynowy).
jest_to(rajdowiec) :-  pozytywne(uprawia, sport), negatywne(czy, sport_druzynowy). 
jest_to(aktor) :- pozytywne(gra, w_filmach).
jest_to(bond) :-  pozytywne(czy, mezczyzna), jest_to(obcokrajowiec), jest_to(aktor), pozytywne(grala, bonda).
jest_to(artysta_muzyczny) :- pozytywne(zajmuje_sie, muzyka).
jest_to(raper) :- jest_to(artysta_muzyczny), pozytywne(czy, rapuje).
jest_to(kompozytor) :- jest_to(artysta_muzyczny), pozytywne(czy, komponuje).
jest_to(wokalista) :- jest_to(artysta_muzyczny), pozytywne(czy, spiewa).
jest_to(mlody_aktor) :- jest_to(aktor), pozytywne(ma, mniej_niz_50lat).
jest_to(kiepski) :- pozytywne(grala, w_swiat_wedlug_kiepskich).
jest_to(komediant) :- jest_to(aktor), pozytywne(gra, w_komediach).
jest_to(aktor_z_filmu_akcji) :- jest_to(aktor), pozytywne(gra, w_filmach_akcji).
jest_to(pianista) :- jest_to(artysta_muzyczny), pozytywne(gra, na_pianinie).
jest_to(martwy) :- pozytywne(czy, nie_zyje).
jest_to(aktor_serlialowy) :- jest_to(aktor), pozytywne(gra, w_serialach).
jest_to(ekscentryk) :- pozytywne(czy, ma_ekscentryczny_ubior).


pozytywne(X,Y) :- xpozytywne(X,Y), !.

pozytywne(X,Y) :- \+xnegatywne(X,Y), pytaj(X,Y,tak).

negatywne(X,Y) :- xnegatywne(X,Y), !.

negatywne(X,Y) :- \+xpozytywne(X,Y), pytaj(X,Y,nie).

pytaj(X,Y,tak) :- !, format('~w ta osoba ~w? (t/n)~n',[X,Y]),
                    read(Reply),
                    pamietaj(X,Y,Reply),
                    (Reply = 't').
                    
pytaj(X,Y,nie) :- !, format('~w ta osoba ~w ? (t/n)~n',[X,Y]),
                    read(Reply),
                    
                    pamietaj(X,Y,Reply),
                    (Reply = 'n').
                    
pamietaj(X,Y,t) :- assertz(xpozytywne(X,Y)).

pamietaj(X,Y,n) :- assertz(xnegatywne(X,Y)).

wyczysc_fakty :- write('Przycisnij cos aby wyjsc'), nl,
                    retractall(xpozytywne(_,_)),
                    retractall(xnegatywne(_,_)),
                    get_char(_).
                    
wykonaj :- osoba_jest(X), !,
            format('~nTwoja osoba moze byc ~w', X),
            nl, wyczysc_fakty.
            
wykonaj :- write('Nie jestem w stanie odgadnac co to za osoba.'), nl,
            wyczysc_fakty.
