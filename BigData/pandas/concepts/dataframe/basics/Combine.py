# merge() — SQL-style joins

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# Left Join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID', how='left')

------------------------------------------------------------------------------------

# Right Join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID', how='right')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# Outer Join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID', how='outer')

------------------------------------------------------------------------------------

# merge on multiple columns

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on=['ID', 'Year'], how='outer')


------------------------------------------------------------------------------------

# join() -  join on index

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1, index=[1, 2])
df2 = pd.DataFrame(data2, index=[1, 2])

df1.join(df2, on='ID')  # if df2's index is 'ID'

------------------------------------------------------------------------------------

# concat() — Stack vertically (axis=0): like UNION ALL

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.concat([df1, df2], axis=1)   # Column-wise


------------------------------------------------------------------------------------

# Many-to-Many Joins in merge()

import pandas as pd

df1 = pd.DataFrame({
    'Team': ['India', 'India'],
    'Player': ['Sachin', 'Dravid']
})

df2 = pd.DataFrame({
    'Team': ['India', 'India'],
    'Year': [2003, 2007]
})

result = pd.merge(df1, df2, on='Team', how='inner')


------------------------------------------------------------------------------------

# Concatenating with MultiIndex

import pandas as pd

df1 = pd.DataFrame({'Runs': [100, 150]}, index=['Sachin', 'Dravid'])
df2 = pd.DataFrame({'Runs': [120, 140]}, index=['Ponting', 'Gilchrist'])

result = pd.concat([df1, df2], keys=['India', 'Australia'])


------------------------------------------------------------------------------------

# Multi-level merge

import pandas as pd

df1 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Player': ['Sachin', 'Dravid', 'Ponting']
})

df2 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Runs': [673, 413, 539]
})

result = pd.merge(df1, df2, on=['Team', 'Year'], how='inner')
print(result)


------------------------------------------------------------------------------------

# Merge on Different Column Names

import pandas as pd

df1 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Player': ['Sachin', 'Dravid', 'Ponting']
})

df2 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Runs': [673, 413, 539]
})

result = pd.merge(df1, df2,
         left_on=['Team', 'Year'],
         right_on=['Country', 'Season'],
         how='inner')

print(result)

------------------------------------------------------------------------------------

# Merge with missing data filled (fillna)


import pandas as pd

df1 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Player': ['Sachin', 'Dravid', 'Ponting']
})

df2 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Runs': [673, 413, 539]
})

merged = pd.merge(df1, df2, on=['Team', 'Year'], how='outer')

# Fill missing Runs with 0
merged['Runs'] = merged['Runs'].fillna(0)

# Or fill all missing values
merged.fillna({'Runs': 0, 'Player': 'Unknown'}, inplace=True)


------------------------------------------------------------------------------------

# Chain merge

import pandas as pd

df1 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Player': ['Sachin', 'Dravid', 'Ponting']
})

df2 = pd.DataFrame({
    'Team': ['India', 'India', 'Australia'],
    'Year': [2003, 2007, 2003],
    'Runs': [673, 413, 539]
})

df1 = pd.merge(df1, df2, on=['Team', 'Year'], how='left')
df_final = pd.merge(df1, df2, on=['Player'], how='left')

# Or using reduce():

from functools import reduce

dfs = [df1, df2, df3]
result = reduce(lambda left, right: pd.merge(left, right, on=['Team', 'Year'], how='outer'), dfs)


------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')

------------------------------------------------------------------------------------

# inner join

import pandas as pd

data1 = {
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'ID': [1,2,3]
}

data2 = {
    'Runs': [10000, 8500, 7000],
    'ID': [2,3,4]
}

df1 = pd.DataFrame(data1)
df2 = pd.DataFrame(data2)

pd.merge(df1, df2, on='ID')