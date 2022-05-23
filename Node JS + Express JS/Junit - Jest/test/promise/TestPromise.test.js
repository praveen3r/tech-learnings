const fetchData = () => {
    return new Promise((resolve, reject) => {
        resolve('peanut butter');
        //reject('error');
    });
}

 test('the data is peanut butter', () => {
    return fetchData().then(data => {
      expect(data).toBe('peanut butter');
    });
  });

  test('the data is peanut butter', async () => {
    const data = await fetchData();
    expect(data).toBe('peanut butter');
  });

  test('the data is peanut butter', async () => {
    await expect(fetchData()).resolves.toBe('peanut butter');
  }); 
  
  /*test('the fetch fails with an error', async () => {
    await expect(fetchData()).rejects.toMatch('error');
  });*/