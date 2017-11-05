import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, App, Slides, ToastController } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { ConfermaPrenotazionePage } from '../confermaprenotazione/confermaprenotazione'
import { JsonDataProvider } from '../../providers/json-data/json-data';

/**
 * Generated class for the QuestionarioPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  templateUrl: 'questionario.html',
})
export class QuestionarioPage {
  @ViewChild(Slides) slides: Slides;
  appello: {idMateria: string, nomeMateria: string, docenti: { nome: string, cognome: string }[], data: string,
    aula: string, descrizione: string, scadenza: string, tipologia: string};

  answers = [];
  
  commonAnswers = [
	"Decisamente no",
    "Pi\u00f9 no che s\u00ec",
    "Pi\u00f9 s\u00ec che no",
    "Decisamente s\u00ec"
  ];
  questionaire = [
  {
    supertitle: "",
    question: "Con riferimento alle unit\u00e0 didattiche relative a questo insegnamento, quale \u00e8 " +
    "la percentuale delle lezioni che ha frequentato in questo anno accademico?",
    required: true,
    radio: true,
    answers: [
      "Non frequentante o inferiore al 50%",
      "Maggiore al 50%"
    ]
  },
  {
    supertitle: "Insegnamento",
    question: "Le conoscenze preliminari possedute sono risultate sufficienti per la comprensione " +
    "degli argomenti previsti nel programma d'esame?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Insegnamento",
    question: "II carico di studio dell'insegnamento \u00e8 proporzionato ai crediti assegnati?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Insegnamento",
    question: "II materiale didattico (indicato e disponibile) \u00e8 adeguato per lo studio della materia?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Insegnamento",
    question: "Le modalit\u00e0 di esame sono state definite in modo chiaro?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Docenza",
    question: "Gli orari di svolgimento di lezioni, esercitazioni e altre eventuali attivit\u00e0 didattiche sono rispettati?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Docenza",
    question: "Il docente stimola/motiva l'interesse verso la disciplina?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Docenza",
    question: "Il docente espone gli argomenti in modo chiaro?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Docenza",
    question: "Le attivit\u00e0 didattiche integrative (esercitazioni, tutorati, " +
    "laboratori, etc...) sono utili all'apprendimento della materia? (Non rispondere se non pertinente)",
    required: false,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Docenza",
    question: "L'insegnamento \u00e8 stato svolto in maniera coerente con quanta dichiarato " +
    "sul sito Web del corso di studio?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Docenza",
    question: "Il docente \u00e8 reperibile per chiarimenti e spiegazioni?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Interesse",
    question: "\u00e8 interessato/a agli argomenti trattati nell'insegnamento?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "Interesse complessivo",
    question: "Si ritiene complessivamente soddisfatto/a dell'insegnamento svolto?",
    required: true,
    radio: true,
    answers: this.commonAnswers
  },
  {
    supertitle: "",
    question: "Suggerimenti (facoltativo)",
    required: false,
    radio: false,
    answers: [
      "Aumentare l'attivit\u00e0 di supporto didattico",
      "Fornire pi\u00f9 conoscenze di base",
      "Eliminare dal programma argomenti gi\u00e0 trattati in altri insegnamenti",
      "Migliorare il coordinamento con altri insegnamenti",
      "Migliorare la qualit\u00e0 del materiale didattico",
      "Fornire in anticipo il materiale didattico",
      "Inserire prove d'esame intermedie",
      "Attivare insegnamenti serali o nel fine settimana",
      "Alleggerire il carico didattico complessivo"
    ]
  }
];
  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App,
    public JsonService: JsonDataProvider, public toastCtrl: ToastController) {
    this.appello = navParams.get('appello');
  }

  ionViewDidLoad() {
    setTimeout(() => {
        this.slides.loop = false;
        this.slides.speed = 600;
        this.slides.lockSwipes(true);
        this.slides.pager = true;
      this.slides.zoom = false;
      this.slides.centeredSlides = false;
        this.slides.update();
      }, 300);
  }

  previous(question: number) {
    this.slides.lockSwipes(false);
    this.slides.slidePrev();
    this.slides.lockSwipes(true);
  }

  next(question: number) {
	if (!this.questionaire[question].required) {
		this.answers[question] = null;
	}
    if (!this.questionaire[question].required ||
      typeof this.answers[question] !== 'undefined') {
      this.slides.lockSwipes(false);
      this.slides.slideNext();
      this.slides.lockSwipes(true);
    } else {
      let toast = this.toastCtrl.create({
        message: 'Domanda obbligatoria',
        duration: 3000,
        showCloseButton: true,
        closeButtonText: "\u2573",
        dismissOnPageChange: true
      });
      toast.present();
    }
  }

  check(question: number, answer: number) {
    if (typeof this.answers[question] === 'undefined') {
      this.answers[question] = new Array(this.questionaire[question].answers.length).fill(false);
    }
    this.answers[question][answer] = !this.answers[question][answer];
  }

  submit() {
    //this.JsonService.sendQuestionaire(this.appello.idMateria, this.answers).then(() => {
      //this.JsonService.book(this.appello.idMateria, this.appello.data).then(() => {
          this.appCtrl.getRootNav().push(ConfermaPrenotazionePage, { appello: this.appello });
      // });
    //});
  }
  
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
}
