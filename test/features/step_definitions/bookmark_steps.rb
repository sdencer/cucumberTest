######### add  ########
Given(/^Open the homepage$/) do
 visit "/"
 sleep 1
end

Given(/^Add a bookmark "([^"]*)"$/) do | book_name |
  fill_in 'bookname', with: book_name
  click 'submitBookMark';
  sleep 1
  end

Given(/^Hava (\d+) result$/) do |expect|
  sleep 1
  result = {'.rescount'}
  sleep 1
  expect(result).to eq expect.to_i
end
######### delete  ########
Given(/^Open the homepage$/) do
 visit "/"
 sleep 1
end

Given(/^Delete a bookmark "([^"]*)"$/) do | book_index |
  #delete 'bookindex', with: book_index
  sleep 1
  end

Given(/^Hava (\d+) result$/) do |expect|
  sleep 1
  result = {'.rescount'}
  sleep 1
  expect(result).to eq expect.to_i
end
