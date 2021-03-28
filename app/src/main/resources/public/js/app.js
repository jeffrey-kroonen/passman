$(document).ready(() => {
    
    $(document).on('click', '#password-entry-field-add-form-row', (e) => {

        let htmlElm = `<div class="row mb-3">
                            <div class="col-sm-4">
                                <label for="">Veldnaam</label>
                                <input type="text" id="" name="passwordEntryFields[]" class="form-control">
                            </div>
                            <div class="col-sm-4">
                                <label for="">Waarde</label>
                                <input type="text" id="" name="passwordEntryValues[]" class="form-control">
                            </div>
                            <div class="col-sm-4">
                                <label for="">Veldtype</label>
                                <select class="form-select" name="passwordEntryTypes[]" id="">
                                    <option value="TEXT">Tekst</option>
                                    <option value="PASSWORD">Wachtwoord</option>
                                </select>
                            </div>
                        </div>`;

        $('#password-entry-field-form-rows').append(htmlElm);
    });
});