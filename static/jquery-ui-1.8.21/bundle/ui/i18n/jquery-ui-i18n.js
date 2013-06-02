/*! jQuery UI - v1.8.21 - 2012-06-05
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.datepicker-af.js, jquery.ui.datepicker-ar-DZ.js, jquery.ui.datepicker-ar.js, jquery.ui.datepicker-az.js, jquery.ui.datepicker-bg.js, jquery.ui.datepicker-bs.js, jquery.ui.datepicker-ca.js, jquery.ui.datepicker-cs.js, jquery.ui.datepicker-cy-GB.js, jquery.ui.datepicker-da.js, jquery.ui.datepicker-de.js, jquery.ui.datepicker-el.js, jquery.ui.datepicker-en-AU.js, jquery.ui.datepicker-en-GB.js, jquery.ui.datepicker-en-NZ.js, jquery.ui.datepicker-eo.js, jquery.ui.datepicker-es.js, jquery.ui.datepicker-et.js, jquery.ui.datepicker-eu.js, jquery.ui.datepicker-fa.js, jquery.ui.datepicker-fi.js, jquery.ui.datepicker-fo.js, jquery.ui.datepicker-fr-CH.js, jquery.ui.datepicker-fr.js, jquery.ui.datepicker-gl.js, jquery.ui.datepicker-he.js, jquery.ui.datepicker-hi.js, jquery.ui.datepicker-hr.js, jquery.ui.datepicker-hu.js, jquery.ui.datepicker-hy.js, jquery.ui.datepicker-id.js, jquery.ui.datepicker-is.js, jquery.ui.datepicker-it.js, jquery.ui.datepicker-ja.js, jquery.ui.datepicker-ka.js, jquery.ui.datepicker-kk.js, jquery.ui.datepicker-km.js, jquery.ui.datepicker-ko.js, jquery.ui.datepicker-lb.js, jquery.ui.datepicker-lt.js, jquery.ui.datepicker-lv.js, jquery.ui.datepicker-mk.js, jquery.ui.datepicker-ml.js, jquery.ui.datepicker-ms.js, jquery.ui.datepicker-nl-BE.js, jquery.ui.datepicker-nl.js, jquery.ui.datepicker-no.js, jquery.ui.datepicker-pl.js, jquery.ui.datepicker-pt-BR.js, jquery.ui.datepicker-pt.js, jquery.ui.datepicker-rm.js, jquery.ui.datepicker-ro.js, jquery.ui.datepicker-ru.js, jquery.ui.datepicker-sk.js, jquery.ui.datepicker-sl.js, jquery.ui.datepicker-sq.js, jquery.ui.datepicker-sr-SR.js, jquery.ui.datepicker-sr.js, jquery.ui.datepicker-sv.js, jquery.ui.datepicker-ta.js, jquery.ui.datepicker-th.js, jquery.ui.datepicker-tj.js, jquery.ui.datepicker-tr.js, jquery.ui.datepicker-uk.js, jquery.ui.datepicker-vi.js, jquery.ui.datepicker-zh-CN.js, jquery.ui.datepicker-zh-HK.js, jquery.ui.datepicker-zh-TW.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */

/* Afrikaans initialisation for the jQuery UI date picker plugin. */
/* Written by Renier Pretorius. */
jQuery(function($){
	$.datepicker.regional['af'] = {
		closeText: 'Selekteer',
		prevText: 'Vorige',
		nextText: 'Volgende',
		currentText: 'Vandag',
		monthNames: ['Januarie','Februarie','Maart','April','Mei','Junie',
		'Julie','Augustus','September','Oktober','November','Desember'],
		monthNamesShort: ['Jan', 'Feb', 'Mrt', 'Apr', 'Mei', 'Jun',
		'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Des'],
		dayNames: ['Sondag', 'Maandag', 'Dinsdag', 'Woensdag', 'Donderdag', 'Vrydag', 'Saterdag'],
		dayNamesShort: ['Son', 'Maa', 'Din', 'Woe', 'Don', 'Vry', 'Sat'],
		dayNamesMin: ['So','Ma','Di','Wo','Do','Vr','Sa'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['af']);
});

/* Algerian Arabic Translation for jQuery UI date picker plugin. (can be used for Tunisia)*/
/* Mohamed Cherif BOUCHELAGHEM -- cherifbouchelaghem@yahoo.fr */

jQuery(function($){
	$.datepicker.regional['ar-DZ'] = {
		closeText: '?????',
		prevText: '&#x3c;??????',
		nextText: '??????&#x3e;',
		currentText: '?????',
		monthNames: ['?????', '?????', '????', '?????', '???', '????',
		'??????', '???', '??????','??????', '??????', '??????'],
		monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
		dayNames: ['?????', '???????', '????????', '????????', '??????', '??????', '?????'],
		dayNamesShort: ['?????', '???????', '????????', '????????', '??????', '??????', '?????'],
		dayNamesMin: ['?????', '???????', '????????', '????????', '??????', '??????', '?????'],
		weekHeader: '?????',
		dateFormat: 'dd/mm/yy',
		firstDay: 6,
  		isRTL: true,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ar-DZ']);
});

/* Arabic Translation for jQuery UI date picker plugin. */
/* Khaled Alhourani -- me@khaledalhourani.com */
/* NOTE: monthNames are the original months names and they are the Arabic names, not the new months name ?????? - ????? and there isn't any Arabic roots for these months */
jQuery(function($){
	$.datepicker.regional['ar'] = {
		closeText: '?????',
		prevText: '&#x3c;??????',
		nextText: '??????&#x3e;',
		currentText: '?????',
		monthNames: ['????? ??????', '????', '????', '?????', '????', '??????',
		'????', '??', '?????',	'????? ?????', '????? ??????', '????? ?????'],
		monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
		dayNames: ['?????', '???????', '????????', '????????', '??????', '??????', '?????'],
		dayNamesShort: ['?????', '???????', '????????', '????????', '??????', '??????', '?????'],
		dayNamesMin: ['?', '?', '?', '?', '?', '?', '?'],
		weekHeader: '?????',
		dateFormat: 'dd/mm/yy',
		firstDay: 6,
  		isRTL: true,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ar']);
});
/* Azerbaijani (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Jamil Najafov (necefov33@gmail.com). */
jQuery(function($) {
	$.datepicker.regional['az'] = {
		closeText: 'Ba?la',
		prevText: '&#x3c;Geri',
		nextText: '?r?li&#x3e;',
		currentText: 'Bug��n',
		monthNames: ['Yanvar','Fevral','Mart','Aprel','May','?yun',
		'?yul','Avqust','Sentyabr','Oktyabr','Noyabr','Dekabr'],
		monthNamesShort: ['Yan','Fev','Mar','Apr','May','?yun',
		'?yul','Avq','Sen','Okt','Noy','Dek'],
		dayNames: ['Bazar','Bazar ert?si','??r??nb? ax?am?','??r??nb?','C��m? ax?am?','C��m?','??nb?'],
		dayNamesShort: ['B','Be','?a','?','Ca','C','?'],
		dayNamesMin: ['B','B','?','��','?','C','?'],
		weekHeader: 'Hf',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['az']);
});
/* Bulgarian initialisation for the jQuery UI date picker plugin. */
/* Written by Stoyan Kyosev (http://svest.org). */
jQuery(function($){
    $.datepicker.regional['bg'] = {
        closeText: '�٧ѧ�ӧ���',
        prevText: '&#x3c;�ߧѧ٧ѧ�',
        nextText: '�ߧѧ��֧�&#x3e;',
		nextBigText: '&#x3e;&#x3e;',
        currentText: '�էߧ֧�',
        monthNames: ['���ߧ�ѧ��','���֧ӧ��ѧ��','���ѧ��','�����ڧ�','���ѧ�','���ߧ�',
        '���ݧ�','���ӧԧ���','���֧��֧ާӧ��','���ܧ��ާӧ��','����֧ާӧ��','���֧ܧ֧ާӧ��'],
        monthNamesShort: ['���ߧ�','���֧�','���ѧ�','�����','���ѧ�','���ߧ�',
        '���ݧ�','���ӧ�','���֧�','���ܧ�','�����','���֧�'],
        dayNames: ['���֧է֧ݧ�','����ߧ֧է֧ݧߧڧ�','������ߧڧ�','�����է�','���֧�ӧ�����','���֧���','����ҧ���'],
        dayNamesShort: ['���֧�','�����','�����','�����','���֧�','���֧�','�����'],
        dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: 'Wk',
        dateFormat: 'dd.mm.yy',
		firstDay: 1,
        isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
    $.datepicker.setDefaults($.datepicker.regional['bg']);
});

/* Bosnian i18n for the jQuery UI date picker plugin. */
/* Written by Kenan Konjo. */
jQuery(function($){
	$.datepicker.regional['bs'] = {
		closeText: 'Zatvori', 
		prevText: '&#x3c;', 
		nextText: '&#x3e;', 
		currentText: 'Danas', 
		monthNames: ['Januar','Februar','Mart','April','Maj','Juni',
		'Juli','August','Septembar','Oktobar','Novembar','Decembar'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Maj','Jun',
		'Jul','Aug','Sep','Okt','Nov','Dec'],
		dayNames: ['Nedelja','Ponedeljak','Utorak','Srijeda','?etvrtak','Petak','Subota'],
		dayNamesShort: ['Ned','Pon','Uto','Sri','?et','Pet','Sub'],
		dayNamesMin: ['Ne','Po','Ut','Sr','?e','Pe','Su'],
		weekHeader: 'Wk',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['bs']);
});
/* Inicialitzaci�� en catal�� per a l'extenci�� 'calendar' per jQuery. */
/* Writers: (joan.leon@gmail.com). */
jQuery(function($){
	$.datepicker.regional['ca'] = {
		closeText: 'Tancar',
		prevText: '&#x3c;Ant',
		nextText: 'Seg&#x3e;',
		currentText: 'Avui',
		monthNames: ['Gener','Febrer','Mar&ccedil;','Abril','Maig','Juny',
		'Juliol','Agost','Setembre','Octubre','Novembre','Desembre'],
		monthNamesShort: ['Gen','Feb','Mar','Abr','Mai','Jun',
		'Jul','Ago','Set','Oct','Nov','Des'],
		dayNames: ['Diumenge','Dilluns','Dimarts','Dimecres','Dijous','Divendres','Dissabte'],
		dayNamesShort: ['Dug','Dln','Dmt','Dmc','Djs','Dvn','Dsb'],
		dayNamesMin: ['Dg','Dl','Dt','Dc','Dj','Dv','Ds'],
		weekHeader: 'Sm',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ca']);
});
/* Czech initialisation for the jQuery UI date picker plugin. */
/* Written by Tomas Muller (tomas@tomas-muller.net). */
jQuery(function($){
	$.datepicker.regional['cs'] = {
		closeText: 'Zav?��t',
		prevText: '&#x3c;D?��ve',
		nextText: 'Pozd��ji&#x3e;',
		currentText: 'Nyn��',
		monthNames: ['leden','��nor','b?ezen','duben','kv��ten','?erven',
        '?ervenec','srpen','z��?��','?��jen','listopad','prosinec'],
		monthNamesShort: ['led','��no','b?e','dub','kv��','?er',
		'?vc','srp','z��?','?��j','lis','pro'],
		dayNames: ['ned��le', 'pond��l��', '��tery', 'st?eda', '?tvrtek', 'p��tek', 'sobota'],
		dayNamesShort: ['ne', 'po', '��t', 'st', '?t', 'p��', 'so'],
		dayNamesMin: ['ne','po','��t','st','?t','p��','so'],
		weekHeader: 'Tyd',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['cs']);
});

/* Welsh/UK initialisation for the jQuery UI date picker plugin. */
/* Written by William Griffiths. */
jQuery(function($){
	$.datepicker.regional['cy-GB'] = {
		closeText: 'Done',
		prevText: 'Prev',
		nextText: 'Next',
		currentText: 'Today',
		monthNames: ['Ionawr','Chwefror','Mawrth','Ebrill','Mai','Mehefin',
		'Gorffennaf','Awst','Medi','Hydref','Tachwedd','Rhagfyr'],
		monthNamesShort: ['Ion', 'Chw', 'Maw', 'Ebr', 'Mai', 'Meh',
		'Gor', 'Aws', 'Med', 'Hyd', 'Tac', 'Rha'],
		dayNames: ['Dydd Sul', 'Dydd Llun', 'Dydd Mawrth', 'Dydd Mercher', 'Dydd Iau', 'Dydd Gwener', 'Dydd Sadwrn'],
		dayNamesShort: ['Sul', 'Llu', 'Maw', 'Mer', 'Iau', 'Gwe', 'Sad'],
		dayNamesMin: ['Su','Ll','Ma','Me','Ia','Gw','Sa'],
		weekHeader: 'Wy',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['cy-GB']);
});
/* Danish initialisation for the jQuery UI date picker plugin. */
/* Written by Jan Christensen ( deletestuff@gmail.com). */
jQuery(function($){
    $.datepicker.regional['da'] = {
		closeText: 'Luk',
        prevText: '&#x3c;Forrige',
		nextText: 'N?ste&#x3e;',
		currentText: 'Idag',
        monthNames: ['Januar','Februar','Marts','April','Maj','Juni',
        'Juli','August','September','Oktober','November','December'],
        monthNamesShort: ['Jan','Feb','Mar','Apr','Maj','Jun',
        'Jul','Aug','Sep','Okt','Nov','Dec'],
		dayNames: ['S?ndag','Mandag','Tirsdag','Onsdag','Torsdag','Fredag','L?rdag'],
		dayNamesShort: ['S?n','Man','Tir','Ons','Tor','Fre','L?r'],
		dayNamesMin: ['S?','Ma','Ti','On','To','Fr','L?'],
		weekHeader: 'Uge',
        dateFormat: 'dd-mm-yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
    $.datepicker.setDefaults($.datepicker.regional['da']);
});

/* German initialisation for the jQuery UI date picker plugin. */
/* Written by Milian Wolff (mail@milianw.de). */
jQuery(function($){
	$.datepicker.regional['de'] = {
		closeText: 'schlie?en',
		prevText: '&#x3c;zur��ck',
		nextText: 'Vor&#x3e;',
		currentText: 'heute',
		monthNames: ['Januar','Februar','M?rz','April','Mai','Juni',
		'Juli','August','September','Oktober','November','Dezember'],
		monthNamesShort: ['Jan','Feb','M?r','Apr','Mai','Jun',
		'Jul','Aug','Sep','Okt','Nov','Dez'],
		dayNames: ['Sonntag','Montag','Dienstag','Mittwoch','Donnerstag','Freitag','Samstag'],
		dayNamesShort: ['So','Mo','Di','Mi','Do','Fr','Sa'],
		dayNamesMin: ['So','Mo','Di','Mi','Do','Fr','Sa'],
		weekHeader: 'KW',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['de']);
});

/* Greek (el) initialisation for the jQuery UI date picker plugin. */
/* Written by Alex Cicovic (http://www.alexcicovic.com) */
jQuery(function($){
	$.datepicker.regional['el'] = {
		closeText: '���˦�?�Ҧɦ̦�',
		prevText: '���ѦϦǦæ�?�̦Ŧͦ�?',
		nextText: '����?�̦Ŧͦ�?',
		currentText: '����?�֦ئ� ��?�ͦ�?',
		monthNames: ['�����ͦϦ�?�Ѧɦ�?','���Ŧ¦ѦϦ�?�Ѧɦ�?','��?�ѦӦɦ�?','���Ц�?�˦ɦ�?','��?�ɦ�?','����?�ͦɦ�?',
		'����?�˦ɦ�?','��?�æϦԦҦӦ�?','���ŦЦ�?�̦¦Ѧɦ�?','���ʦ�?�¦Ѧɦ�?','����?�̦¦Ѧɦ�?','���Ŧ�?�̦¦Ѧɦ�?'],
		monthNamesShort: ['������','���Ŧ�','������','���Ц�','������','���ϦԦ�',
		'���ϦԦ�','���Ԧ�','���Ŧ�','���ʦ�','���Ϧ�','���Ŧ�'],
		dayNames: ['���ԦѦɦ���?','���ŦԦ�?�Ѧ�','����?�Ӧ�','���Ŧ�?�ѦӦ�','��?�̦ЦӦ�','�����Ѧ��ҦʦŦ�?','��?�¦¦��Ӧ�'],
		dayNamesShort: ['���Ԧ�','���Ŧ�','���Ѧ�','���Ŧ�','���Ŧ�','������','������'],
		dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: '���¦�',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['el']);
});
/* English/Australia initialisation for the jQuery UI date picker plugin. */
/* Based on the en-GB initialisation. */
jQuery(function($){
	$.datepicker.regional['en-AU'] = {
		closeText: 'Done',
		prevText: 'Prev',
		nextText: 'Next',
		currentText: 'Today',
		monthNames: ['January','February','March','April','May','June',
		'July','August','September','October','November','December'],
		monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
		'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
		dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
		dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
		dayNamesMin: ['Su','Mo','Tu','We','Th','Fr','Sa'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['en-AU']);
});

/* English/UK initialisation for the jQuery UI date picker plugin. */
/* Written by Stuart. */
jQuery(function($){
	$.datepicker.regional['en-GB'] = {
		closeText: 'Done',
		prevText: 'Prev',
		nextText: 'Next',
		currentText: 'Today',
		monthNames: ['January','February','March','April','May','June',
		'July','August','September','October','November','December'],
		monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
		'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
		dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
		dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
		dayNamesMin: ['Su','Mo','Tu','We','Th','Fr','Sa'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['en-GB']);
});

/* English/New Zealand initialisation for the jQuery UI date picker plugin. */
/* Based on the en-GB initialisation. */
jQuery(function($){
	$.datepicker.regional['en-NZ'] = {
		closeText: 'Done',
		prevText: 'Prev',
		nextText: 'Next',
		currentText: 'Today',
		monthNames: ['January','February','March','April','May','June',
		'July','August','September','October','November','December'],
		monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
		'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
		dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
		dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
		dayNamesMin: ['Su','Mo','Tu','We','Th','Fr','Sa'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['en-NZ']);
});

/* Esperanto initialisation for the jQuery UI date picker plugin. */
/* Written by Olivier M. (olivierweb@ifrance.com). */
jQuery(function($){
	$.datepicker.regional['eo'] = {
		closeText: 'Fermi',
		prevText: '&lt;Anta',
		nextText: 'Sekv&gt;',
		currentText: 'Nuna',
		monthNames: ['Januaro','Februaro','Marto','Aprilo','Majo','Junio',
		'Julio','A?gusto','Septembro','Oktobro','Novembro','Decembro'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Maj','Jun',
		'Jul','A?g','Sep','Okt','Nov','Dec'],
		dayNames: ['Diman?o','Lundo','Mardo','Merkredo','?a?do','Vendredo','Sabato'],
		dayNamesShort: ['Dim','Lun','Mar','Mer','?a?','Ven','Sab'],
		dayNamesMin: ['Di','Lu','Ma','Me','?a','Ve','Sa'],
		weekHeader: 'Sb',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['eo']);
});

/* Inicializaci��n en espa?ol para la extensi��n 'UI date picker' para jQuery. */
/* Traducido por Vester (xvester@gmail.com). */
jQuery(function($){
	$.datepicker.regional['es'] = {
		closeText: 'Cerrar',
		prevText: '&#x3c;Ant',
		nextText: 'Sig&#x3e;',
		currentText: 'Hoy',
		monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
		'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
		monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
		'Jul','Ago','Sep','Oct','Nov','Dic'],
		dayNames: ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
		dayNamesShort: ['Dom','Lun','Mar','Mi&eacute;','Juv','Vie','S&aacute;b'],
		dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S&aacute;'],
		weekHeader: 'Sm',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['es']);
});
/* Estonian initialisation for the jQuery UI date picker plugin. */
/* Written by Mart S?mermaa (mrts.pydev at gmail com). */
jQuery(function($){
	$.datepicker.regional['et'] = {
		closeText: 'Sulge',
		prevText: 'Eelnev',
		nextText: 'J?rgnev',
		currentText: 'T?na',
		monthNames: ['Jaanuar','Veebruar','M?rts','Aprill','Mai','Juuni',
		'Juuli','August','September','Oktoober','November','Detsember'],
		monthNamesShort: ['Jaan', 'Veebr', 'M?rts', 'Apr', 'Mai', 'Juuni',
		'Juuli', 'Aug', 'Sept', 'Okt', 'Nov', 'Dets'],
		dayNames: ['P��hap?ev', 'Esmasp?ev', 'Teisip?ev', 'Kolmap?ev', 'Neljap?ev', 'Reede', 'Laup?ev'],
		dayNamesShort: ['P��hap', 'Esmasp', 'Teisip', 'Kolmap', 'Neljap', 'Reede', 'Laup'],
		dayNamesMin: ['P','E','T','K','N','R','L'],
		weekHeader: 'n?d',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['et']);
}); 
/* Euskarako oinarria 'UI date picker' jquery-ko extentsioarentzat */
/* Karrikas-ek itzulia (karrikas@karrikas.com) */
jQuery(function($){
	$.datepicker.regional['eu'] = {
		closeText: 'Egina',
		prevText: '&#x3c;Aur',
		nextText: 'Hur&#x3e;',
		currentText: 'Gaur',
		monthNames: ['urtarrila','otsaila','martxoa','apirila','maiatza','ekaina',
			'uztaila','abuztua','iraila','urria','azaroa','abendua'],
		monthNamesShort: ['urt.','ots.','mar.','api.','mai.','eka.',
			'uzt.','abu.','ira.','urr.','aza.','abe.'],
		dayNames: ['igandea','astelehena','asteartea','asteazkena','osteguna','ostirala','larunbata'],
		dayNamesShort: ['ig.','al.','ar.','az.','og.','ol.','lr.'],
		dayNamesMin: ['ig','al','ar','az','og','ol','lr'],
		weekHeader: 'As',
		dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['eu']);
});
/* Persian (Farsi) Translation for the jQuery UI date picker plugin. */
/* Javad Mowlanezhad -- jmowla@gmail.com */
/* Jalali calendar should supported soon! (Its implemented but I have to test it) */
jQuery(function($) {
	$.datepicker.regional['fa'] = {
		closeText: '????',
		prevText: '&#x3C;????',
		nextText: '????&#x3E;',
		currentText: '?????',
		monthNames: [
			'???????',
			'????????',
			'?????',
			'???',
			'?????',
			'??????',
			'???',
			'????',
			'???',
			'??',
			'????',
			'?????'
		],
		monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
		dayNames: [
			'??????',
			'??????',
			'???????',
			'????????',
			'???????',
			'????',
			'????'
		],
		dayNamesShort: [
			'?',
			'?',
			'?',
			'?',
			'?',
			'?', 
			'?'
		],
		dayNamesMin: [
			'?',
			'?',
			'?',
			'?',
			'?',
			'?', 
			'?'
		],
		weekHeader: '??',
		dateFormat: 'yy/mm/dd',
		firstDay: 6,
		isRTL: true,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['fa']);
});
/* Finnish initialisation for the jQuery UI date picker plugin. */
/* Written by Harri Kilpi? (harrikilpio@gmail.com). */
jQuery(function($){
	$.datepicker.regional['fi'] = {
		closeText: 'Sulje',
		prevText: '&#xAB;Edellinen',
		nextText: 'Seuraava&#xBB;',
		currentText: 'T&#xE4;n&#xE4;&#xE4;n',
		monthNames: ['Tammikuu','Helmikuu','Maaliskuu','Huhtikuu','Toukokuu','Kes&#xE4;kuu',
		'Hein&#xE4;kuu','Elokuu','Syyskuu','Lokakuu','Marraskuu','Joulukuu'],
		monthNamesShort: ['Tammi','Helmi','Maalis','Huhti','Touko','Kes&#xE4;',
		'Hein&#xE4;','Elo','Syys','Loka','Marras','Joulu'],
		dayNamesShort: ['Su','Ma','Ti','Ke','To','Pe','La'],
		dayNames: ['Sunnuntai','Maanantai','Tiistai','Keskiviikko','Torstai','Perjantai','Lauantai'],
		dayNamesMin: ['Su','Ma','Ti','Ke','To','Pe','La'],
		weekHeader: 'Vk',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['fi']);
});

/* Faroese initialisation for the jQuery UI date picker plugin */
/* Written by Sverri Mohr Olsen, sverrimo@gmail.com */
jQuery(function($){
	$.datepicker.regional['fo'] = {
		closeText: 'Lat aftur',
		prevText: '&#x3c;Fyrra',
		nextText: 'N?sta&#x3e;',
		currentText: '�� dag',
		monthNames: ['Januar','Februar','Mars','Apr��l','Mei','Juni',
		'Juli','August','September','Oktober','November','Desember'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Mei','Jun',
		'Jul','Aug','Sep','Okt','Nov','Des'],
		dayNames: ['Sunnudagur','M��nadagur','Tysdagur','Mikudagur','H��sdagur','Fr��ggjadagur','Leyardagur'],
		dayNamesShort: ['Sun','M��n','Tys','Mik','H��s','Fr��','Ley'],
		dayNamesMin: ['Su','M��','Ty','Mi','H��','Fr','Le'],
		weekHeader: 'Vk',
		dateFormat: 'dd-mm-yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['fo']);
});

/* Swiss-French initialisation for the jQuery UI date picker plugin. */
/* Written Martin Voelkle (martin.voelkle@e-tc.ch). */
jQuery(function($){
	$.datepicker.regional['fr-CH'] = {
		closeText: 'Fermer',
		prevText: '&#x3c;Pr��c',
		nextText: 'Suiv&#x3e;',
		currentText: 'Courant',
		monthNames: ['Janvier','F��vrier','Mars','Avril','Mai','Juin',
		'Juillet','Ao?t','Septembre','Octobre','Novembre','D��cembre'],
		monthNamesShort: ['Jan','F��v','Mar','Avr','Mai','Jun',
		'Jul','Ao?','Sep','Oct','Nov','D��c'],
		dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
		dayNamesShort: ['Dim','Lun','Mar','Mer','Jeu','Ven','Sam'],
		dayNamesMin: ['Di','Lu','Ma','Me','Je','Ve','Sa'],
		weekHeader: 'Sm',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['fr-CH']);
});
/* French initialisation for the jQuery UI date picker plugin. */
/* Written by Keith Wood (kbwood{at}iinet.com.au),
              St��phane Nahmani (sholby@sholby.net),
              St��phane Raimbault <stephane.raimbault@gmail.com> */
jQuery(function($){
	$.datepicker.regional['fr'] = {
		closeText: 'Fermer',
		prevText: 'Pr��c��dent',
		nextText: 'Suivant',
		currentText: 'Aujourd\'hui',
		monthNames: ['Janvier','F��vrier','Mars','Avril','Mai','Juin',
		'Juillet','Ao?t','Septembre','Octobre','Novembre','D��cembre'],
		monthNamesShort: ['Janv.','F��vr.','Mars','Avril','Mai','Juin',
		'Juil.','Ao?t','Sept.','Oct.','Nov.','D��c.'],
		dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
		dayNamesShort: ['Dim.','Lun.','Mar.','Mer.','Jeu.','Ven.','Sam.'],
		dayNamesMin: ['D','L','M','M','J','V','S'],
		weekHeader: 'Sem.',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['fr']);
});

/* Galician localization for 'UI date picker' jQuery extension. */
/* Translated by Jorge Barreiro <yortx.barry@gmail.com>. */
jQuery(function($){
	$.datepicker.regional['gl'] = {
		closeText: 'Pechar',
		prevText: '&#x3c;Ant',
		nextText: 'Seg&#x3e;',
		currentText: 'Hoxe',
		monthNames: ['Xaneiro','Febreiro','Marzo','Abril','Maio','Xu?o',
		'Xullo','Agosto','Setembro','Outubro','Novembro','Decembro'],
		monthNamesShort: ['Xan','Feb','Mar','Abr','Mai','Xu?',
		'Xul','Ago','Set','Out','Nov','Dec'],
		dayNames: ['Domingo','Luns','Martes','M&eacute;rcores','Xoves','Venres','S&aacute;bado'],
		dayNamesShort: ['Dom','Lun','Mar','M&eacute;r','Xov','Ven','S&aacute;b'],
		dayNamesMin: ['Do','Lu','Ma','M&eacute;','Xo','Ve','S&aacute;'],
		weekHeader: 'Sm',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['gl']);
});
/* Hebrew initialisation for the UI Datepicker extension. */
/* Written by Amir Hardon (ahardon at gmail dot com). */
jQuery(function($){
	$.datepicker.regional['he'] = {
		closeText: '????',
		prevText: '&#x3c;?????',
		nextText: '???&#x3e;',
		currentText: '????',
		monthNames: ['?????','??????','???','?????','???','????',
		'????','??????','??????','???????','??????','?????'],
		monthNamesShort: ['???','???','???','???','???','????',
		'????','???','???','???','???','???'],
		dayNames: ['?????','???','?????','?????','?????','????','???'],
		dayNamesShort: ['?\'','?\'','?\'','?\'','?\'','?\'','???'],
		dayNamesMin: ['?\'','?\'','?\'','?\'','?\'','?\'','???'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: true,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['he']);
});

/* Hindi initialisation for the jQuery UI date picker plugin. */
/* Written by Michael Dawart. */
jQuery(function($){
	$.datepicker.regional['hi'] = {
		closeText: '???',
		prevText: '?????',
		nextText: '????',
		currentText: '??',
		monthNames: ['????? ','?????','?????','??????','??','???',
		'?????','????? ','???????','???????','??????','???????'],
		monthNamesShort: ['??', '??', '?????', '??????', '??', '???',
		'?????', '??', '???', '????', '??', '??'],
		dayNames: ['??????', '??????', '???????', '??????', '???????', '????????', '??????'],
		dayNamesShort: ['???', '???', '????', '???', '????', '?????', '???'],
		dayNamesMin: ['???', '???', '????', '???', '????', '?????', '???'],
		weekHeader: '?????',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['hi']);
});

/* Croatian i18n for the jQuery UI date picker plugin. */
/* Written by Vjekoslav Nesek. */
jQuery(function($){
	$.datepicker.regional['hr'] = {
		closeText: 'Zatvori',
		prevText: '&#x3c;',
		nextText: '&#x3e;',
		currentText: 'Danas',
		monthNames: ['Sije?anj','Velja?a','O?ujak','Travanj','Svibanj','Lipanj',
		'Srpanj','Kolovoz','Rujan','Listopad','Studeni','Prosinac'],
		monthNamesShort: ['Sij','Velj','O?u','Tra','Svi','Lip',
		'Srp','Kol','Ruj','Lis','Stu','Pro'],
		dayNames: ['Nedjelja','Ponedjeljak','Utorak','Srijeda','?etvrtak','Petak','Subota'],
		dayNamesShort: ['Ned','Pon','Uto','Sri','?et','Pet','Sub'],
		dayNamesMin: ['Ne','Po','Ut','Sr','?e','Pe','Su'],
		weekHeader: 'Tje',
		dateFormat: 'dd.mm.yy.',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['hr']);
});
/* Hungarian initialisation for the jQuery UI date picker plugin. */
/* Written by Istvan Karaszi (jquery@spam.raszi.hu). */
jQuery(function($){
	$.datepicker.regional['hu'] = {
		closeText: 'bez��r',
		prevText: 'vissza',
		nextText: 'el?re',
		currentText: 'ma',
		monthNames: ['Janu��r', 'Febru��r', 'M��rcius', '��prilis', 'M��jus', 'J��nius',
		'J��lius', 'Augusztus', 'Szeptember', 'Okt��ber', 'November', 'December'],
		monthNamesShort: ['Jan', 'Feb', 'M��r', '��pr', 'M��j', 'J��n',
		'J��l', 'Aug', 'Szep', 'Okt', 'Nov', 'Dec'],
		dayNames: ['Vas��rnap', 'H��tf?', 'Kedd', 'Szerda', 'Cs��t?rt?k', 'P��ntek', 'Szombat'],
		dayNamesShort: ['Vas', 'H��t', 'Ked', 'Sze', 'Cs��', 'P��n', 'Szo'],
		dayNamesMin: ['V', 'H', 'K', 'Sze', 'Cs', 'P', 'Szo'],
		weekHeader: 'H��t',
		dateFormat: 'yy.mm.dd.',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['hu']);
});

/* Armenian(UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Levon Zakaryan (levon.zakaryan@gmail.com)*/
jQuery(function($){
	$.datepicker.regional['hy'] = {
		closeText: '?????',
		prevText: '&#x3c;???.',
		nextText: '???.&#x3e;',
		currentText: '?????',
		monthNames: ['???????','???????','????','?????','?????','??????',
		'??????','???????','?????????','?????????','????????','?????????'],
		monthNamesShort: ['?????','????','????','???','?????','??????',
		'????','???','???','???','???','???'],
		dayNames: ['??????','?????????','?????????','??????????','?????????','??????','?????'],
		dayNamesShort: ['???','???','???','???','???','????','???'],
		dayNamesMin: ['???','???','???','???','???','????','???'],
		weekHeader: '???',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['hy']);
});
/* Indonesian initialisation for the jQuery UI date picker plugin. */
/* Written by Deden Fathurahman (dedenf@gmail.com). */
jQuery(function($){
	$.datepicker.regional['id'] = {
		closeText: 'Tutup',
		prevText: '&#x3c;mundur',
		nextText: 'maju&#x3e;',
		currentText: 'hari ini',
		monthNames: ['Januari','Februari','Maret','April','Mei','Juni',
		'Juli','Agustus','September','Oktober','Nopember','Desember'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Mei','Jun',
		'Jul','Agus','Sep','Okt','Nop','Des'],
		dayNames: ['Minggu','Senin','Selasa','Rabu','Kamis','Jumat','Sabtu'],
		dayNamesShort: ['Min','Sen','Sel','Rab','kam','Jum','Sab'],
		dayNamesMin: ['Mg','Sn','Sl','Rb','Km','jm','Sb'],
		weekHeader: 'Mg',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['id']);
});
/* Icelandic initialisation for the jQuery UI date picker plugin. */
/* Written by Haukur H. Thorsson (haukur@eskill.is). */
jQuery(function($){
	$.datepicker.regional['is'] = {
		closeText: 'Loka',
		prevText: '&#x3c; Fyrri',
		nextText: 'N&aelig;sti &#x3e;',
		currentText: '&Iacute; dag',
		monthNames: ['Jan&uacute;ar','Febr&uacute;ar','Mars','Apr&iacute;l','Ma&iacute','J&uacute;n&iacute;',
		'J&uacute;l&iacute;','&Aacute;g&uacute;st','September','Okt&oacute;ber','N&oacute;vember','Desember'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Ma&iacute;','J&uacute;n',
		'J&uacute;l','&Aacute;g&uacute;','Sep','Okt','N&oacute;v','Des'],
		dayNames: ['Sunnudagur','M&aacute;nudagur','&THORN;ri&eth;judagur','Mi&eth;vikudagur','Fimmtudagur','F&ouml;studagur','Laugardagur'],
		dayNamesShort: ['Sun','M&aacute;n','&THORN;ri','Mi&eth;','Fim','F&ouml;s','Lau'],
		dayNamesMin: ['Su','M&aacute;','&THORN;r','Mi','Fi','F&ouml;','La'],
		weekHeader: 'Vika',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['is']);
});
/* Italian initialisation for the jQuery UI date picker plugin. */
/* Written by Antonello Pasella (antonello.pasella@gmail.com). */
jQuery(function($){
	$.datepicker.regional['it'] = {
		closeText: 'Chiudi',
		prevText: '&#x3c;Prec',
		nextText: 'Succ&#x3e;',
		currentText: 'Oggi',
		monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno',
			'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
		monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu',
			'Lug','Ago','Set','Ott','Nov','Dic'],
		dayNames: ['Domenica','Luned&#236','Marted&#236','Mercoled&#236','Gioved&#236','Venerd&#236','Sabato'],
		dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],
		dayNamesMin: ['Do','Lu','Ma','Me','Gi','Ve','Sa'],
		weekHeader: 'Sm',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['it']);
});

/* Japanese initialisation for the jQuery UI date picker plugin. */
/* Written by Kentaro SATO (kentaro@ranvis.com). */
jQuery(function($){
	$.datepicker.regional['ja'] = {
		closeText: '�]����',
		prevText: '&#x3c;ǰ',
		nextText: '��&#x3e;',
		currentText: '����',
		monthNames: ['1��','2��','3��','4��','5��','6��',
		'7��','8��','9��','10��','11��','12��'],
		monthNamesShort: ['1��','2��','3��','4��','5��','6��',
		'7��','8��','9��','10��','11��','12��'],
		dayNames: ['������','������','������','ˮ����','ľ����','������','������'],
		dayNamesShort: ['��','��','��','ˮ','ľ','��','��'],
		dayNamesMin: ['��','��','��','ˮ','ľ','��','��'],
		weekHeader: '�L',
		dateFormat: 'yy/mm/dd',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '��'};
	$.datepicker.setDefaults($.datepicker.regional['ja']);
});
/* Georgian (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Lado Lomidze (lado.lomidze@gmail.com). */
jQuery(function($){
	$.datepicker.regional['ka'] = {
		closeText: '???????',
		prevText: '&#x3c; ????',
		nextText: '??????? &#x3e;',
		currentText: '????',
		monthNames: ['???????','?????????','?????','??????','?????','??????', '??????','???????','??????????','?????????','????????','?????????'],
		monthNamesShort: ['???','???','???','???','???','???', '???','???','???','???','???','???'],
		dayNames: ['?????','????????','?????????','?????????','?????????','?????????','??????'],
		dayNamesShort: ['??','???','???','???','???','???','???'],
		dayNamesMin: ['??','???','???','???','???','???','???'],
		weekHeader: '?????',
		dateFormat: 'dd-mm-yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ka']);
});

/* Kazakh (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Dmitriy Karasyov (dmitriy.karasyov@gmail.com). */
jQuery(function($){
	$.datepicker.regional['kk'] = {
		closeText: '���ѧҧ�',
		prevText: '&#x3c;���ݧէ�??��',
		nextText: '���֧ݧ֧�?&#x3e;',
		currentText: '��?��?��',
		monthNames: ['?��?��ѧ�','��?��ѧ�','���ѧ����','��?��?��','���ѧާ��','���ѧ����',
		'��?�ݧէ�','���ѧާ��','?����?�֧ۧ�','?�ѧ٧ѧ�','?�ѧ�ѧ��','���֧ݧ��?��ѧ�'],
		monthNamesShort: ['?��?','��?��','���ѧ�','��?��','���ѧ�','���ѧ�',
		'��?��','���ѧ�','?���','?�ѧ�','?�ѧ�','���֧�'],
		dayNames: ['���֧ܧ�֧ߧ�?','��?�ۧ�֧ߧ�?','���֧ۧ�֧ߧ�?','��?���֧ߧ�?','���֧ۧ�֧ߧ�?','��?�ާ�','���֧ߧ�?'],
		dayNamesShort: ['�اܧ�','�է��','����','����','�ҧ��','�اާ�','��ߧ�'],
		dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: '����',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['kk']);
});

/* Khmer initialisation for the jQuery calendar extension. */
/* Written by Chandara Om (chandara.teacher@gmail.com). */
jQuery(function($){
	$.datepicker.regional['km'] = {
		closeText: '????????',
		prevText: '???',
		nextText: '???????',
		currentText: '????????',
		monthNames: ['????','??????','????','????','????','??????',
		'??????','????','?????','????','????????','????'],
		monthNamesShort: ['????','??????','????','????','????','??????',
		'??????','????','?????','????','????????','????'],
		dayNames: ['???????', '????', '??????', '???', '??????????', '?????', '????'],
		dayNamesShort: ['??', '?', '?', '??', '????', '??', '??'],
		dayNamesMin: ['??', '?', '?', '??', '????', '??', '??'],
		weekHeader: '???????',
		dateFormat: 'dd-mm-yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['km']);
});

/* Korean initialisation for the jQuery calendar extension. */
/* Written by DaeKwon Kang (ncrash.dk@gmail.com), Edited by Genie. */
jQuery(function($){
	$.datepicker.regional['ko'] = {
		closeText: '??',
		prevText: '???',
		nextText: '???',
		currentText: '??',
		monthNames: ['1?','2?','3?','4?','5?','6?',
		'7?','8?','9?','10?','11?','12?'],
		monthNamesShort: ['1?','2?','3?','4?','5?','6?',
		'7?','8?','9?','10?','11?','12?'],
		dayNames: ['???','???','???','???','???','???','???'],
		dayNamesShort: ['?','?','?','?','?','?','?'],
		dayNamesMin: ['?','?','?','?','?','?','?'],
		weekHeader: 'Wk',
		dateFormat: 'yy-mm-dd',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '?'};
	$.datepicker.setDefaults($.datepicker.regional['ko']);
});
/* Luxembourgish initialisation for the jQuery UI date picker plugin. */
/* Written by Michel Weimerskirch <michel@weimerskirch.net> */
jQuery(function($){
	$.datepicker.regional['lb'] = {
		closeText: 'F?erdeg',
		prevText: 'Zr��ck',
		nextText: 'Weider',
		currentText: 'Haut',
		monthNames: ['Januar','Februar','M?erz','Abr?ll','Mee','Juni',
		'Juli','August','September','Oktober','November','Dezember'],
		monthNamesShort: ['Jan', 'Feb', 'M?e', 'Abr', 'Mee', 'Jun',
		'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Dez'],
		dayNames: ['Sonndeg', 'M��indeg', 'D?nschdeg', 'M?ttwoch', 'Donneschdeg', 'Freideg', 'Samschdeg'],
		dayNamesShort: ['Son', 'M��i', 'D?n', 'M?t', 'Don', 'Fre', 'Sam'],
		dayNamesMin: ['So','M��','D?','M?','Do','Fr','Sa'],
		weekHeader: 'W',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['lb']);
});

/* Lithuanian (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* @author Arturas Paleicikas <arturas@avalon.lt> */
jQuery(function($){
	$.datepicker.regional['lt'] = {
		closeText: 'U?daryti',
		prevText: '&#x3c;Atgal',
		nextText: 'Pirmyn&#x3e;',
		currentText: '?iandien',
		monthNames: ['Sausis','Vasaris','Kovas','Balandis','Gegu??','Bir?elis',
		'Liepa','Rugpj��tis','Rugs?jis','Spalis','Lapkritis','Gruodis'],
		monthNamesShort: ['Sau','Vas','Kov','Bal','Geg','Bir',
		'Lie','Rugp','Rugs','Spa','Lap','Gru'],
		dayNames: ['sekmadienis','pirmadienis','antradienis','tre?iadienis','ketvirtadienis','penktadienis','?e?tadienis'],
		dayNamesShort: ['sek','pir','ant','tre','ket','pen','?e?'],
		dayNamesMin: ['Se','Pr','An','Tr','Ke','Pe','?e'],
		weekHeader: 'Wk',
		dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['lt']);
});
/* Latvian (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* @author Arturas Paleicikas <arturas.paleicikas@metasite.net> */
jQuery(function($){
	$.datepicker.regional['lv'] = {
		closeText: 'Aizv��rt',
		prevText: 'Iepr',
		nextText: 'N��ka',
		currentText: '?odien',
		monthNames: ['Janv��ris','Febru��ris','Marts','Apr��lis','Maijs','J��nijs',
		'J��lijs','Augusts','Septembris','Oktobris','Novembris','Decembris'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Mai','J��n',
		'J��l','Aug','Sep','Okt','Nov','Dec'],
		dayNames: ['sv��tdiena','pirmdiena','otrdiena','tre?diena','ceturtdiena','piektdiena','sestdiena'],
		dayNamesShort: ['svt','prm','otr','tre','ctr','pkt','sst'],
		dayNamesMin: ['Sv','Pr','Ot','Tr','Ct','Pk','Ss'],
		weekHeader: 'Nav',
		dateFormat: 'dd-mm-yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['lv']);
});
/* Macedonian i18n for the jQuery UI date picker plugin. */
/* Written by Stojce Slavkovski. */
jQuery(function($){
	$.datepicker.regional['mk'] = {
		closeText: '���ѧ�ӧ���',
		prevText: '&#x3C;',
		nextText: '&#x3E;',
		currentText: '���֧ߧ֧�',
		monthNames: ['?�ѧߧ�ѧ��','���֧ӧ��ѧ��','���ѧ��','�����ڧ�','����?','?��ߧ�',
		'?��ݧ�','���ӧԧ���','���֧��֧ާӧ��','���ܧ��ާӧ��','����֧ާӧ��','���֧ܧ֧ާӧ��'],
		monthNamesShort: ['?�ѧ�','���֧�','���ѧ�','�����','����?','?���',
		'?���','���ӧ�','���֧�','���ܧ�','�����','���֧�'],
		dayNames: ['���֧է֧ݧ�','����ߧ֧է֧ݧߧڧ�','������ߧڧ�','����֧է�','���֧�ӧ����','���֧���','���ѧҧ���'],
		dayNamesShort: ['���֧�','�����','�����','�����','���֧�','���֧�','���ѧ�'],
		dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: '���֧�',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['mk']);
});

/* Malayalam (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Saji Nediyanchath (saji89@gmail.com). */
jQuery(function($){
	$.datepicker.regional['ml'] = {
		closeText: '???',
		prevText: '?????????',  
		nextText: '???????? ',
		currentText: '?????',
		monthNames: ['??????','?????????','?????????','????????','????','?????',
		'????','????????','????????????','?????????','???????','????????'],
		monthNamesShort: ['???', '????', '?????', '?????', '????', '?????',
		'????', '??', '????', '?????', '???', '???'],
		dayNames: ['??????', '????????', '?????', '??????', '??????', '??????', '???'],
		dayNamesShort: ['???', '?????', '?????', '???', '??????', '??????', '???'],
		dayNamesMin: ['??','??','??','??','????','??','?'],
		weekHeader: '?',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ml']);
});

/* Malaysian initialisation for the jQuery UI date picker plugin. */
/* Written by Mohd Nawawi Mohamad Jamili (nawawi@ronggeng.net). */
jQuery(function($){
	$.datepicker.regional['ms'] = {
		closeText: 'Tutup',
		prevText: '&#x3c;Sebelum',
		nextText: 'Selepas&#x3e;',
		currentText: 'hari ini',
		monthNames: ['Januari','Februari','Mac','April','Mei','Jun',
		'Julai','Ogos','September','Oktober','November','Disember'],
		monthNamesShort: ['Jan','Feb','Mac','Apr','Mei','Jun',
		'Jul','Ogo','Sep','Okt','Nov','Dis'],
		dayNames: ['Ahad','Isnin','Selasa','Rabu','Khamis','Jumaat','Sabtu'],
		dayNamesShort: ['Aha','Isn','Sel','Rab','kha','Jum','Sab'],
		dayNamesMin: ['Ah','Is','Se','Ra','Kh','Ju','Sa'],
		weekHeader: 'Mg',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ms']);
});
/* Dutch (Belgium) initialisation for the jQuery UI date picker plugin. */
/* David De Sloovere @DavidDeSloovere */
jQuery(function($){
	$.datepicker.regional['nl-BE'] = {
		closeText: 'Sluiten',
		prevText: '��',
		nextText: '��',
		currentText: 'Vandaag',
		monthNames: ['januari', 'februari', 'maart', 'april', 'mei', 'juni',
		'juli', 'augustus', 'september', 'oktober', 'november', 'december'],
		monthNamesShort: ['jan', 'feb', 'mrt', 'apr', 'mei', 'jun',
		'jul', 'aug', 'sep', 'okt', 'nov', 'dec'],
		dayNames: ['zondag', 'maandag', 'dinsdag', 'woensdag', 'donderdag', 'vrijdag', 'zaterdag'],
		dayNamesShort: ['zon', 'maa', 'din', 'woe', 'don', 'vri', 'zat'],
		dayNamesMin: ['zo', 'ma', 'di', 'wo', 'do', 'vr', 'za'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['nl-BE']);
});

/* Dutch (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Mathias Bynens <http://mathiasbynens.be/> */
jQuery(function($){
	$.datepicker.regional.nl = {
		closeText: 'Sluiten',
		prevText: '��',
		nextText: '��',
		currentText: 'Vandaag',
		monthNames: ['januari', 'februari', 'maart', 'april', 'mei', 'juni',
		'juli', 'augustus', 'september', 'oktober', 'november', 'december'],
		monthNamesShort: ['jan', 'feb', 'mrt', 'apr', 'mei', 'jun',
		'jul', 'aug', 'sep', 'okt', 'nov', 'dec'],
		dayNames: ['zondag', 'maandag', 'dinsdag', 'woensdag', 'donderdag', 'vrijdag', 'zaterdag'],
		dayNamesShort: ['zon', 'maa', 'din', 'woe', 'don', 'vri', 'zat'],
		dayNamesMin: ['zo', 'ma', 'di', 'wo', 'do', 'vr', 'za'],
		weekHeader: 'Wk',
		dateFormat: 'dd-mm-yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional.nl);
});
/* Norwegian initialisation for the jQuery UI date picker plugin. */
/* Written by Naimdjon Takhirov (naimdjon@gmail.com). */

jQuery(function($){
  $.datepicker.regional['no'] = {
    closeText: 'Lukk',
    prevText: '&laquo;Forrige',
    nextText: 'Neste&raquo;',
    currentText: 'I dag',
    monthNames: ['januar','februar','mars','april','mai','juni','juli','august','september','oktober','november','desember'],
    monthNamesShort: ['jan','feb','mar','apr','mai','jun','jul','aug','sep','okt','nov','des'],
    dayNamesShort: ['s?n','man','tir','ons','tor','fre','l?r'],
    dayNames: ['s?ndag','mandag','tirsdag','onsdag','torsdag','fredag','l?rdag'],
    dayNamesMin: ['s?','ma','ti','on','to','fr','l?'],
    weekHeader: 'Uke',
    dateFormat: 'dd.mm.yy',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: ''
  };
  $.datepicker.setDefaults($.datepicker.regional['no']);
});

/* Polish initialisation for the jQuery UI date picker plugin. */
/* Written by Jacek Wysocki (jacek.wysocki@gmail.com). */
jQuery(function($){
	$.datepicker.regional['pl'] = {
		closeText: 'Zamknij',
		prevText: '&#x3c;Poprzedni',
		nextText: 'Nast?pny&#x3e;',
		currentText: 'Dzi?',
		monthNames: ['Stycze��','Luty','Marzec','Kwiecie��','Maj','Czerwiec',
		'Lipiec','Sierpie��','Wrzesie��','Pa?dziernik','Listopad','Grudzie��'],
		monthNamesShort: ['Sty','Lu','Mar','Kw','Maj','Cze',
		'Lip','Sie','Wrz','Pa','Lis','Gru'],
		dayNames: ['Niedziela','Poniedzia?ek','Wtorek','?roda','Czwartek','Pi?tek','Sobota'],
		dayNamesShort: ['Nie','Pn','Wt','?r','Czw','Pt','So'],
		dayNamesMin: ['N','Pn','Wt','?r','Cz','Pt','So'],
		weekHeader: 'Tydz',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['pl']);
});

/* Brazilian initialisation for the jQuery UI date picker plugin. */
/* Written by Leonildo Costa Silva (leocsilva@gmail.com). */
jQuery(function($){
	$.datepicker.regional['pt-BR'] = {
		closeText: 'Fechar',
		prevText: '&#x3c;Anterior',
		nextText: 'Pr&oacute;ximo&#x3e;',
		currentText: 'Hoje',
		monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',
		'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',
		'Jul','Ago','Set','Out','Nov','Dez'],
		dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','S&aacute;bado'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S&aacute;b'],
		dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','S&aacute;b'],
		weekHeader: 'Sm',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['pt-BR']);
});
/* Portuguese initialisation for the jQuery UI date picker plugin. */
jQuery(function($){
	$.datepicker.regional['pt'] = {
		closeText: 'Fechar',
		prevText: '&#x3c;Anterior',
		nextText: 'Seguinte',
		currentText: 'Hoje',
		monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',
		'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',
		'Jul','Ago','Set','Out','Nov','Dez'],
		dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','S&aacute;bado'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S&aacute;b'],
		dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','S&aacute;b'],
		weekHeader: 'Sem',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['pt']);
});
/* Romansh initialisation for the jQuery UI date picker plugin. */
/* Written by Yvonne Gienal (yvonne.gienal@educa.ch). */
jQuery(function($){
	$.datepicker.regional['rm'] = {
		closeText: 'Serrar',
		prevText: '&#x3c;Suandant',
		nextText: 'Precedent&#x3e;',
		currentText: 'Actual',
		monthNames: ['Schaner','Favrer','Mars','Avrigl','Matg','Zercladur', 'Fanadur','Avust','Settember','October','November','December'],
		monthNamesShort: ['Scha','Fev','Mar','Avr','Matg','Zer', 'Fan','Avu','Sett','Oct','Nov','Dec'],
		dayNames: ['Dumengia','Glindesdi','Mardi','Mesemna','Gievgia','Venderdi','Sonda'],
		dayNamesShort: ['Dum','Gli','Mar','Mes','Gie','Ven','Som'],
		dayNamesMin: ['Du','Gl','Ma','Me','Gi','Ve','So'],
		weekHeader: 'emna',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['rm']);
});

/* Romanian initialisation for the jQuery UI date picker plugin.
 *
 * Written by Edmond L. (ll_edmond@walla.com)
 * and Ionut G. Stan (ionut.g.stan@gmail.com)
 */
jQuery(function($){
	$.datepicker.regional['ro'] = {
		closeText: '?nchide',
		prevText: '&laquo; Luna precedent?',
		nextText: 'Luna urm?toare &raquo;',
		currentText: 'Azi',
		monthNames: ['Ianuarie','Februarie','Martie','Aprilie','Mai','Iunie',
		'Iulie','August','Septembrie','Octombrie','Noiembrie','Decembrie'],
		monthNamesShort: ['Ian', 'Feb', 'Mar', 'Apr', 'Mai', 'Iun',
		'Iul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
		dayNames: ['Duminic?', 'Luni', 'Mar?i', 'Miercuri', 'Joi', 'Vineri', 'Samb?t?'],
		dayNamesShort: ['Dum', 'Lun', 'Mar', 'Mie', 'Joi', 'Vin', 'Sam'],
		dayNamesMin: ['Du','Lu','Ma','Mi','Jo','Vi','Sa'],
		weekHeader: 'S?pt',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ro']);
});

/* Russian (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Andrew Stromnov (stromnov@gmail.com). */
jQuery(function($){
	$.datepicker.regional['ru'] = {
		closeText: '���ѧܧ����',
		prevText: '&#x3c;����֧�',
		nextText: '���ݧ֧�&#x3e;',
		currentText: '���֧ԧ�էߧ�',
		monthNames: ['���ߧӧѧ��','���֧ӧ�ѧݧ�','���ѧ��','�����֧ݧ�','���ѧ�','����ߧ�',
		'����ݧ�','���ӧԧ���','���֧ߧ��ҧ��','���ܧ��ҧ��','�����ҧ��','���֧ܧѧҧ��'],
		monthNamesShort: ['���ߧ�','���֧�','���ѧ�','�����','���ѧ�','�����',
		'�����','���ӧ�','���֧�','���ܧ�','�����','���֧�'],
		dayNames: ['�ӧ��ܧ�֧�֧ߧ��','���ߧ֧է֧ݧ�ߧڧ�','�ӧ���ߧڧ�','���֧է�','��֧�ӧ֧��','����ߧڧ��','���ҧҧ���'],
		dayNamesShort: ['�ӧ��','��ߧ�','�ӧ��','����','����','����','��ҧ�'],
		dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: '���֧�',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ru']);
});
/* Slovak initialisation for the jQuery UI date picker plugin. */
/* Written by Vojtech Rinik (vojto@hmm.sk). */
jQuery(function($){
	$.datepicker.regional['sk'] = {
		closeText: 'Zavrie?',
		prevText: '&#x3c;Predch��dzaj��ci',
		nextText: 'Nasleduj��ci&#x3e;',
		currentText: 'Dnes',
		monthNames: ['Janu��r','Febru��r','Marec','Apr��l','M��j','J��n',
		'J��l','August','September','Okt��ber','November','December'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','M��j','J��n',
		'J��l','Aug','Sep','Okt','Nov','Dec'],
		dayNames: ['Nede?a','Pondelok','Utorok','Streda','?tvrtok','Piatok','Sobota'],
		dayNamesShort: ['Ned','Pon','Uto','Str','?tv','Pia','Sob'],
		dayNamesMin: ['Ne','Po','Ut','St','?t','Pia','So'],
		weekHeader: 'Ty',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['sk']);
});

/* Slovenian initialisation for the jQuery UI date picker plugin. */
/* Written by Jaka Jancar (jaka@kubje.org). */
/* c = &#x10D;, s = &#x161; z = &#x17E; C = &#x10C; S = &#x160; Z = &#x17D; */
jQuery(function($){
	$.datepicker.regional['sl'] = {
		closeText: 'Zapri',
		prevText: '&lt;Prej&#x161;nji',
		nextText: 'Naslednji&gt;',
		currentText: 'Trenutni',
		monthNames: ['Januar','Februar','Marec','April','Maj','Junij',
		'Julij','Avgust','September','Oktober','November','December'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Maj','Jun',
		'Jul','Avg','Sep','Okt','Nov','Dec'],
		dayNames: ['Nedelja','Ponedeljek','Torek','Sreda','&#x10C;etrtek','Petek','Sobota'],
		dayNamesShort: ['Ned','Pon','Tor','Sre','&#x10C;et','Pet','Sob'],
		dayNamesMin: ['Ne','Po','To','Sr','&#x10C;e','Pe','So'],
		weekHeader: 'Teden',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['sl']);
});

/* Albanian initialisation for the jQuery UI date picker plugin. */
/* Written by Flakron Bytyqi (flakron@gmail.com). */
jQuery(function($){
	$.datepicker.regional['sq'] = {
		closeText: 'mbylle',
		prevText: '&#x3c;mbrapa',
		nextText: 'P?rpara&#x3e;',
		currentText: 'sot',
		monthNames: ['Janar','Shkurt','Mars','Prill','Maj','Qershor',
		'Korrik','Gusht','Shtator','Tetor','N?ntor','Dhjetor'],
		monthNamesShort: ['Jan','Shk','Mar','Pri','Maj','Qer',
		'Kor','Gus','Sht','Tet','N?n','Dhj'],
		dayNames: ['E Diel','E H?n?','E Mart?','E M?rkur?','E Enjte','E Premte','E Shtune'],
		dayNamesShort: ['Di','H?','Ma','M?','En','Pr','Sh'],
		dayNamesMin: ['Di','H?','Ma','M?','En','Pr','Sh'],
		weekHeader: 'Ja',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['sq']);
});

/* Serbian i18n for the jQuery UI date picker plugin. */
/* Written by Dejan Dimi?. */
jQuery(function($){
	$.datepicker.regional['sr-SR'] = {
		closeText: 'Zatvori',
		prevText: '&#x3c;',
		nextText: '&#x3e;',
		currentText: 'Danas',
		monthNames: ['Januar','Februar','Mart','April','Maj','Jun',
		'Jul','Avgust','Septembar','Oktobar','Novembar','Decembar'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','Maj','Jun',
		'Jul','Avg','Sep','Okt','Nov','Dec'],
		dayNames: ['Nedelja','Ponedeljak','Utorak','Sreda','?etvrtak','Petak','Subota'],
		dayNamesShort: ['Ned','Pon','Uto','Sre','?et','Pet','Sub'],
		dayNamesMin: ['Ne','Po','Ut','Sr','?e','Pe','Su'],
		weekHeader: 'Sed',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['sr-SR']);
});

/* Serbian i18n for the jQuery UI date picker plugin. */
/* Written by Dejan Dimi?. */
jQuery(function($){
	$.datepicker.regional['sr'] = {
		closeText: '���ѧ�ӧ���',
		prevText: '&#x3c;',
		nextText: '&#x3e;',
		currentText: '���ѧߧѧ�',
		monthNames: ['?�ѧߧ�ѧ�','���֧ҧ��ѧ�','���ѧ��','�����ڧ�','����?','?���',
		'?���','���ӧԧ���','���֧��֧ާҧѧ�','���ܧ��ҧѧ�','����ӧ֧ާҧѧ�','���֧�֧ާҧѧ�'],
		monthNamesShort: ['?�ѧ�','���֧�','���ѧ�','�����','����?','?���',
		'?���','���ӧ�','���֧�','���ܧ�','�����','���֧�'],
		dayNames: ['���֧է�?��','����ߧ֧է�?�ѧ�','������ѧ�','����֧է�','���֧�ӧ��ѧ�','���֧�ѧ�','����ҧ���'],
		dayNamesShort: ['���֧�','�����','�����','�����','���֧�','���֧�','�����'],
		dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: '���֧�',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['sr']);
});

/* Swedish initialisation for the jQuery UI date picker plugin. */
/* Written by Anders Ekdahl ( anders@nomadiz.se). */
jQuery(function($){
    $.datepicker.regional['sv'] = {
		closeText: 'St?ng',
        prevText: '&laquo;F?rra',
		nextText: 'N?sta&raquo;',
		currentText: 'Idag',
        monthNames: ['Januari','Februari','Mars','April','Maj','Juni',
        'Juli','Augusti','September','Oktober','November','December'],
        monthNamesShort: ['Jan','Feb','Mar','Apr','Maj','Jun',
        'Jul','Aug','Sep','Okt','Nov','Dec'],
		dayNamesShort: ['S?n','M?n','Tis','Ons','Tor','Fre','L?r'],
		dayNames: ['S?ndag','M?ndag','Tisdag','Onsdag','Torsdag','Fredag','L?rdag'],
		dayNamesMin: ['S?','M?','Ti','On','To','Fr','L?'],
		weekHeader: 'Ve',
        dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
    $.datepicker.setDefaults($.datepicker.regional['sv']);
});

/* Tamil (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by S A Sureshkumar (saskumar@live.com). */
jQuery(function($){
	$.datepicker.regional['ta'] = {
		closeText: '????',
		prevText: '?????????',
		nextText: '????????',
		currentText: '?????',
		monthNames: ['??','????','???????','????????','??????','???',
		'???','????','?????????','??????','??????????','???????'],
		monthNamesShort: ['??','????','???','????','????','???',
		'???','??','???','???','????','????'],
		dayNames: ['???????????????','????????????','???????????????','??????????','????????????','?????????????','??????????'],
		dayNamesShort: ['??????','???????','????????','?????','???????','??????','???'],
		dayNamesMin: ['??','??','??','??','??','??','?'],
		weekHeader: '����',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ta']);
});

/* Thai initialisation for the jQuery UI date picker plugin. */
/* Written by pipo (pipo@sixhead.com). */
jQuery(function($){
	$.datepicker.regional['th'] = {
		closeText: '???',
		prevText: '&laquo;&nbsp;????',
		nextText: '?????&nbsp;&raquo;',
		currentText: '??????',
		monthNames: ['??????','??????????','??????','??????','???????','????????',
		'???????','???????','???????','??????','?????????','???????'],
		monthNamesShort: ['?.?.','?.?.','??.?.','??.?.','?.?.','??.?.',
		'?.?.','?.?.','?.?.','?.?.','?.?.','?.?.'],
		dayNames: ['???????','??????','??????','???','????????','?????','?????'],
		dayNamesShort: ['??.','?.','?.','?.','??.','?.','?.'],
		dayNamesMin: ['??.','?.','?.','?.','??.','?.','?.'],
		weekHeader: 'Wk',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['th']);
});
/* Tajiki (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Abdurahmon Saidov (saidovab@gmail.com). */
jQuery(function($){
	$.datepicker.regional['tj'] = {
		closeText: '���է�ާ�',
		prevText: '&#x3c;?�ѧ��',
		nextText: '���֧�&#x3e;',
		currentText: '���ާ�?��',
		monthNames: ['���ߧӧѧ�','���֧ӧ�ѧ�','���ѧ��','�����֧�','���ѧ�','�����',
		'�����','���ӧԧ���','���֧ߧ��ҧ�','���ܧ��ҧ�','�����ҧ�','���֧ܧѧҧ�'],
		monthNamesShort: ['���ߧ�','���֧�','���ѧ�','�����','���ѧ�','�����',
		'�����','���ӧ�','���֧�','���ܧ�','�����','���֧�'],
		dayNames: ['��ܧ�ѧߧҧ�','�է��ѧߧҧ�','��֧�ѧߧҧ�','�����ѧߧҧ�','��ѧ�?��ѧߧҧ�','?��ާ��','��ѧߧҧ�'],
		dayNamesShort: ['��ܧ�','�է��','��֧�','����','��ѧ�','?���','��ѧ�'],
		dayNamesMin: ['����','����','����','����','����','?��','����'],
		weekHeader: '����',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['tj']);
});
/* Turkish initialisation for the jQuery UI date picker plugin. */
/* Written by Izzet Emre Erkan (kara@karalamalar.net). */
jQuery(function($){
	$.datepicker.regional['tr'] = {
		closeText: 'kapat',
		prevText: '&#x3c;geri',
		nextText: 'ileri&#x3e',
		currentText: 'bug��n',
		monthNames: ['Ocak','?ubat','Mart','Nisan','May?s','Haziran',
		'Temmuz','A?ustos','Eyl��l','Ekim','Kas?m','Aral?k'],
		monthNamesShort: ['Oca','?ub','Mar','Nis','May','Haz',
		'Tem','A?u','Eyl','Eki','Kas','Ara'],
		dayNames: ['Pazar','Pazartesi','Sal?','?ar?amba','Per?embe','Cuma','Cumartesi'],
		dayNamesShort: ['Pz','Pt','Sa','?a','Pe','Cu','Ct'],
		dayNamesMin: ['Pz','Pt','Sa','?a','Pe','Cu','Ct'],
		weekHeader: 'Hf',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['tr']);
});
/* Ukrainian (UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Maxim Drogobitskiy (maxdao@gmail.com). */
/* Corrected by Igor Milla (igor.fsp.milla@gmail.com). */
jQuery(function($){
	$.datepicker.regional['uk'] = {
		closeText: '���ѧܧ�ڧ��',
		prevText: '&#x3c;',
		nextText: '&#x3e;',
		currentText: '�����ԧ�է�?',
		monthNames: ['��?��֧ߧ�','�����ڧ�','���֧�֧٧֧ߧ�','����?��֧ߧ�','����ѧӧ֧ߧ�','���֧�ӧ֧ߧ�',
		'���ڧ�֧ߧ�','���֧��֧ߧ�','���֧�֧�֧ߧ�','����ӧ�֧ߧ�','���ڧ����ѧ�','�����է֧ߧ�'],
		monthNamesShort: ['��?��','�����','���֧�','����?','�����','���֧�',
		'���ڧ�','���֧�','���֧�','�����','���ڧ�','�����'],
		dayNames: ['�ߧ֧�?�ݧ�','���ߧ֧�?�ݧ��','��?�ӧ�����','��֧�֧է�','��֧�ӧ֧�','�ᡯ���ߧڧ��','���ҧ���'],
		dayNamesShort: ['�ߧ֧�','��ߧ�','��?��','����','����','����','��ҧ�'],
		dayNamesMin: ['����','����','����','����','����','����','����'],
		weekHeader: '���ڧ�',
		dateFormat: 'dd/mm/yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['uk']);
});
/* Vietnamese initialisation for the jQuery UI date picker plugin. */
/* Translated by Le Thanh Huy (lthanhhuy@cit.ctu.edu.vn). */
jQuery(function($){
	$.datepicker.regional['vi'] = {
		closeText: '?��ng',
		prevText: '&#x3c;Tr??c',
		nextText: 'Ti?p&#x3e;',
		currentText: 'H?m nay',
		monthNames: ['Th��ng M?t', 'Th��ng Hai', 'Th��ng Ba', 'Th��ng T?', 'Th��ng N?m', 'Th��ng S��u',
		'Th��ng B?y', 'Th��ng T��m', 'Th��ng Ch��n', 'Th��ng M??i', 'Th��ng M??i M?t', 'Th��ng M??i Hai'],
		monthNamesShort: ['Th��ng 1', 'Th��ng 2', 'Th��ng 3', 'Th��ng 4', 'Th��ng 5', 'Th��ng 6',
		'Th��ng 7', 'Th��ng 8', 'Th��ng 9', 'Th��ng 10', 'Th��ng 11', 'Th��ng 12'],
		dayNames: ['Ch? Nh?t', 'Th? Hai', 'Th? Ba', 'Th? T?', 'Th? N?m', 'Th? S��u', 'Th? B?y'],
		dayNamesShort: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
		dayNamesMin: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
		weekHeader: 'Tu',
		dateFormat: 'dd/mm/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['vi']);
});

/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
jQuery(function($){
	$.datepicker.regional['zh-CN'] = {
		closeText: '�ر�',
		prevText: '&#x3c;����',
		nextText: '����&#x3e;',
		currentText: '����',
		monthNames: ['һ��','����','����','����','����','����',
		'����','����','����','ʮ��','ʮһ��','ʮ����'],
		monthNamesShort: ['һ','��','��','��','��','��',
		'��','��','��','ʮ','ʮһ','ʮ��'],
		dayNames: ['������','����һ','���ڶ�','������','������','������','������'],
		dayNamesShort: ['����','��һ','�ܶ�','����','����','����','����'],
		dayNamesMin: ['��','һ','��','��','��','��','��'],
		weekHeader: '��',
		dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '��'};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});

/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by SCCY (samuelcychan@gmail.com). */
jQuery(function($){
	$.datepicker.regional['zh-HK'] = {
		closeText: '�P�]',
		prevText: '&#x3c;����',
		nextText: '����&#x3e;',
		currentText: '����',
		monthNames: ['һ��','����','����','����','����','����',
		'����','����','����','ʮ��','ʮһ��','ʮ����'],
		monthNamesShort: ['һ','��','��','��','��','��',
		'��','��','��','ʮ','ʮһ','ʮ��'],
		dayNames: ['������','����һ','���ڶ�','������','������','������','������'],
		dayNamesShort: ['����','��һ','�ܶ�','����','����','����','����'],
		dayNamesMin: ['��','һ','��','��','��','��','��'],
		weekHeader: '��',
		dateFormat: 'dd-mm-yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '��'};
	$.datepicker.setDefaults($.datepicker.regional['zh-HK']);
});

/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Ressol (ressol@gmail.com). */
jQuery(function($){
	$.datepicker.regional['zh-TW'] = {
		closeText: '�P�]',
		prevText: '&#x3c;����',
		nextText: '����&#x3e;',
		currentText: '����',
		monthNames: ['һ��','����','����','����','����','����',
		'����','����','����','ʮ��','ʮһ��','ʮ����'],
		monthNamesShort: ['һ','��','��','��','��','��',
		'��','��','��','ʮ','ʮһ','ʮ��'],
		dayNames: ['������','����һ','���ڶ�','������','������','������','������'],
		dayNamesShort: ['����','��һ','�ܶ�','����','����','����','����'],
		dayNamesMin: ['��','һ','��','��','��','��','��'],
		weekHeader: '��',
		dateFormat: 'yy/mm/dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '��'};
	$.datepicker.setDefaults($.datepicker.regional['zh-TW']);
});
