document.addEventListener('DOMContentLoaded', function () {
    const backButton = document.getElementById('backButton');
    const forwardButton = document.getElementById('forwardButton');
    const currentMonthYear = document.getElementById('currentMonthYear');
    const days = [
        document.getElementById('montagDatum'),
        document.getElementById('dienstagDatum'),
        document.getElementById('mittwochDatum'),
        document.getElementById('donnerstagDatum'),
        document.getElementById('freitagDatum'),
        document.getElementById('samstagDatum'),
        document.getElementById('sonntagDatum')
    ];

    let currentDate = new Date();

    function updateCalendar() {
        const options = {year: 'numeric', month: 'long'};
        currentMonthYear.textContent = currentDate.toLocaleDateString('de-DE', options);

        days.forEach((day, index) => {
            const date = new Date(currentDate);
            date.setDate(currentDate.getDate() + (index - 1));
            day.textContent = date.toLocaleDateString('de-DE');
        });
    }

    backButton.addEventListener('click', function () {
        currentDate.setDate(currentDate.getDate() - 7);
        updateCalendar();
    });

    forwardButton.addEventListener('click', function () {
        currentDate.setDate(currentDate.getDate() + 7);
        updateCalendar();
    });

    updateCalendar();
});