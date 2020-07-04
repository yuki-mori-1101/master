document.addEventListener('DOMContentLoaded', function() {
    var elem = document.getElementById('elem');
    var elem2 = document.getElementById('elem2');

    elem.addEventListener('mouseover', function() {
        this.className = 'highlight';
    }, false);

    elem.addEventListener('mouseout', function() {
        this.className = '';
    }, false);

    elem2.addEventListener('click', function() {
        this.className = (this.className === 'highlight' ? '' : 'highlight');
    }, false);

    elem3.addEventListener('click', function() {
        this.classList.toggle('highlight');
    }, false);

}, false);