test('test callback', () => {
    function callback(data){
        expect(data).toBe('Shreeram');
    }

    fetchData(callback);
})

const fetchData = (callback) => {
    callback('Shreeram');
}